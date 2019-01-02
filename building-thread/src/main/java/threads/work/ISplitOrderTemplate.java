package threads.work;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:52 2018/12/27.
 */
public abstract class ISplitOrderTemplate<T extends Comparable<T>> implements ISplitOrder<T> {

    private List<List<T>> maxGroupList = new ArrayList<>();


    /**
     * 获取最接近limit的值
     *
     * @param dataSet      数据集合
     * @param max          最大值限制
     * @param goodsMax     数量限制
     * @param add          相加规则
     * @param defaultValue 默认值
     * @return
     */
    public List<List<T>> getNearestValueCombines(List<T> dataSet, T max, int goodsMax, BinaryOperator<T> add, T defaultValue) {
        T nearest = defaultValue;
        List<List<T>> matchedGroups = new ArrayList<>();
        for (int i = 1; i <= Math.min(goodsMax, dataSet.size()); i++) {
            List<List<T>> combines = listCombines(dataSet, add, max, defaultValue, i);
            if (CollectionUtils.isEmpty(combines)) continue;    //如果为空的话，那么进行下个循环
            for (List<T> combine : combines) {
                //求出这个组合的和
                T sum = combine.stream().reduce(defaultValue, add);
                //sum在(max,+∞) U（-∞,nearest），不做处理
                if (sum.compareTo(max) > 0 || sum.compareTo(nearest) < 0) continue;
                //sum == nearest,将组合加入matchedGroups
                if (sum.equals(nearest)) {
                    matchedGroups.add(combine);
                    continue;
                }
                //sum在(nearest,max]，那么重置nearest和matchedGroups，并在matchedGroups中新加这个组合
                nearest = sum;
                matchedGroups.clear(); //新清除前面保存的组合，如果有的话
                matchedGroups.add(combine);
            }
        }
        return matchedGroups;
    }


    /**
     * 使用多线程来计算值，非fork/join 算法 + fork/join算法来算
     *
     * @param dataSet      待计算的数据集
     * @param max          最大值限制
     * @param goodsMax     物品的最大值
     * @param add          加法原则
     * @param defaultValue 默认值
     * @return
     */
    public List<List<T>> getMaxValOfCombines(List<T> dataSet, T max, int goodsMax, BinaryOperator<T> add, T defaultValue) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors + 1);
        List<List<T>> groupsFromCombines = new CopyOnWriteArrayList<>();
        for (int i = 1; i < goodsMax + 1; i++) {
            int finalI = i;
            Future<List<List<T>>> result = executorService.submit(() -> listMaxGroups(dataSet, add, max, defaultValue, finalI));
            try {
                List<List<T>> maxGroups = result.get(30, TimeUnit.SECONDS);
                groupsFromCombines.addAll(maxGroups);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();

        List<List<T>> groups = groupsFromCombines.stream()
                .sorted((o1, o2) -> {
                    T o1Sum = o1.stream().reduce(defaultValue, add);
                    T o2Sum = o2.stream().reduce(defaultValue, add);
                    return o1Sum.compareTo(o2Sum) * -1;
                }).collect(Collectors.toList());
        T maxVal = groups.get(0).stream().reduce(defaultValue, this::selfAdd);
        return groups.stream()
                .filter(it -> {
                    T val = it.stream().reduce(defaultValue, this::selfAdd);
                    return val.compareTo(maxVal) == 0;
                })
                .collect(Collectors.toList());
    }

    public void compareAndSetMaxGroups(List<List<T>> subMaxGroupList, BinaryOperator<T> add, T defaultVal) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (CollectionUtils.isEmpty(maxGroupList)) {
                maxGroupList = subMaxGroupList;
            } else {
                T curMaxVal = maxGroupList.get(0).stream().reduce(defaultVal, add);
                T comMaxVal = subMaxGroupList.get(0).stream().reduce(defaultVal, add);
                int result = curMaxVal.compareTo(comMaxVal);
                //如果当前的最大值小于新的最大值，那么重新设置
                if (result < 0)
                    maxGroupList = subMaxGroupList;
            }
        } finally {
            lock.unlock();
        }
    }


    /**
     * 获取未过滤的组合
     *
     * @param dataSet    数据集合
     * @param add        加法规则
     * @param max        最大值限制
     * @param defaultVal 默认值
     * @param count      排列组合中的选择元素
     * @return 组合集合
     */
    @Override
    public List<List<T>> listCombines(List<T> dataSet, BinaryOperator<T> add, T max, T defaultVal, int count) {
        return listMaxGroups(dataSet, add, max, defaultVal, count);
    }

    /**
     * 查找树的最上层的叶子节点
     *
     * @param root 根
     * @return 最上层的叶子节点
     */
    @Override
    public List<OrderNode<T>> getTopLeaves(OrderNode<T> root) {
        List<OrderNode<T>> subOrders = root.getSubOrders();
        if (CollectionUtils.isEmpty(subOrders)) return Collections.singletonList(root);   //如果子节点为空的话，那么入参就是叶子节点,直接返回
        boolean stop = false;
        List<OrderNode<T>> topLeaves = new ArrayList<>();
        List<OrderNode<T>> subOrdersTmp = subOrders;
        int depth = 0;          //当前循环的深度
        while (!stop) {
            //对subOrders 进行循环，收集他们的子类，如果所有的子类都不是叶子节点，那么继续循环，如果有一个是叶子节点，那么中断循环，返回在这个深度上所有的叶子节点
            //叶子节点的判定标准是没有子节点了,subOrders == null|| subOrders.size ==0
            List<OrderNode<T>> nextLoopOrderNodes = new ArrayList<>();    // 这个数量可能会比较大，但应该也不会有多大，几百，几千？
            depth++;
            for (OrderNode<T> tOrderNode : subOrdersTmp) {
                List<OrderNode<T>> tSubOrders = tOrderNode.getSubOrders();
                if (CollectionUtils.isEmpty(tSubOrders)) {
                    stop = true;
                    topLeaves.add(tOrderNode);                    //如果子节点为空的话，那么是叶子节点，增加到topLeaves中
                } else {
                    nextLoopOrderNodes.addAll(tSubOrders);           //如果不是叶子节点的话，那么增加到下次循环子节点的集合中,用于下次循环
                }
            }
            //这次的循环节点结束后，判断stop值
            if (!stop) {
                //如果循环没有终止，那么把当前的循环节点设置为nextLoopOrderNodes
                subOrdersTmp = nextLoopOrderNodes;
            }
        }
        return topLeaves;
    }

    /**
     * 数据是否超过了标准
     *
     * @param compared 待比较的对象
     * @param limit    限制
     * @return 是否
     */
    @Override
    public boolean isBeyondLimit(T compared, T limit) {
        return false;
    }


    private List<List<T>> listMaxGroups(List<T> dataSet, BinaryOperator<T> add,
                                        T max, T defaultVal, int count) {
        System.out.println("----------------" + Thread.currentThread().getName());
        dataSet = dataSet.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(dataSet)) return null;
        List<List<T>> targetGroups = new ArrayList<>();

        List<T> combine = new ArrayList<>(0);
        boolean[] flags = new boolean[dataSet.size()];
        // 初始化组合标识
        for (int i = 0; i < flags.length; i++) {
            flags[i] = i < count;
        }

        int point = 0;
        int nextPoint;
        int numCount = 0;
        int sum = 0;
        boolean flagTemp;
        while (true) {
            // 判断是否全部移位完毕
            for (int i = flags.length - 1; i >= flags.length - count; i--) {
                if (flags[i]) {
                    sum++;
                }
            }
            // 根据移位生成数据
            for (int i = 0; i < flags.length; i++) {
                if (flags[i]) {
                    point = i;
                    combine.add(dataSet.get(point));
                    numCount++;
                    if (numCount == count) {
                        break;
                    }
                }
            }
            // 往返回值列表添加数据
            maxGroups(targetGroups, combine, add, max, defaultVal);
//            maxGroups.add(tmp);
            // 当数组的最后count位全部为true退出
            if (sum == count) {
                break;
            }
            sum = 0;
            // 修改从左往右第一个10变成01
            for (int i = 0; i < flags.length - 1; i++) {
                if (flags[i] && !flags[i + 1]) {
                    point = i;
                    nextPoint = i + 1;
                    flags[point] = false;
                    flags[nextPoint] = true;
                    break;
                }
            }

            // 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++) {
                for (int j = i; j < point - 1; j++) {
                    if (!flags[i]) {
                        flagTemp = flags[i];
                        flags[i] = flags[j + 1];
                        flags[j + 1] = flagTemp;
                    }
                }
            }
            // 重置
            combine.clear();
            numCount = 0;
        }

        System.out.println(Thread.currentThread().getName() + " end-------------------");
        return targetGroups;
    }


    /**
     * 把group添加到groups中
     *
     * @param groups 待添加的groups
     * @param group  被添加的数据集合
     */
    private void maxGroups(List<List<T>> groups, List<T> group, BinaryOperator<T> add,
                           T max, T defaultValue) {
        T curMax = CollectionUtils.isEmpty(groups) ? defaultValue : groups.get(0).stream().reduce(defaultValue, add);
        //获取待插入的组合的和
        T groupResult = group.stream().reduce(defaultValue, add);
        //如果带插入的组合之和大于最大限制的话，跳过
        if (isBeyondLimit(groupResult, max)) return;
        //如果当前的最大值小于待添加的组合的和的话，那么清除groups，添加group作为新的groups
        int cur2group = curMax.compareTo(groupResult);
        //如果分组之和小于当前最大值的话，那么直接返回
        if (cur2group > 0) return;
        if (cur2group < 0) {
            //如果组合和大于当前最大的和的话，重置组合最大值
            groups.clear();
            groups.add(new ArrayList<>(group));
        } else {
            groups.add(new ArrayList<>(group));
        }
    }

}