package util;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/29
 * @Time: 10:11
 * @Description:
 * @version: 1.0.0
 */
public class IndListUtil {
    /**
     * 忽略大小写比较集合是否包含一个元素
     *
     * @param compare  比较的元素
     * @param iterable 集合
     * @return 比较结果
     */
    public static boolean containIgnoreCase(String compare, Iterable<String> iterable) {
        for (String ele : iterable) {
            if (ele.equalsIgnoreCase(compare)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将 list分成指定组数
     *
     * @param allList 待分组的数据
     * @param group   要分多少组
     * @return 分组结果
     */
    public static <T> List<List<T>> partitionList(List<T> allList, int group) {
        if (CollectionUtils.isEmpty(allList) || group == 0) {
            return null;
        }
        List<List<T>> partitions = new ArrayList<>();
        int size = allList.size();
        int intAverageCount = size / group;
        int extra = size % group;
        int[] groupSize = new int[group];
        int start = 0;
        int end;
        for (int i = 0; i < group; i++) {
            if (i < extra) {
                groupSize[i] = intAverageCount + 1;
            } else {
                groupSize[i] = intAverageCount;
            }
            //如果groupSize 为0，那么退出循环
            if (groupSize[i] == 0) {
                break;
            }
            end = start + groupSize[i];
            List<T> groupData = allList.subList(start, end);
            partitions.add(groupData);
            start = start + groupSize[i];
        }
        return partitions;
    }

    /**
     * 获取集合的所有子集
     *
     * @param filters 集合数据
     * @param count   多少位的集合
     * @return 所有子集
     */
    public static <T> List<List<T>> combine(List<T> filters, int count) {
        //过滤为空的的数据
        filters = filters.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(filters)) return null;
        List<List<T>> list = new ArrayList<>();
        Object[] filter = new Object[count];
        boolean[] flags = new boolean[filters.size()];
        // 初始化组合标识
        for (int i = 0; i < flags.length; i++) {
            flags[i] = i < count;
        }

        int point = 0;
        int nextPoint = 0;
        int numCount = 0;
        int sum = 0;
        boolean flagTemp = true;
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
//                    filter[numCount] = filters[point];
                    filter[numCount] = filters.get(point);
                    numCount++;
                    if (numCount == count) {
                        break;
                    }
                }
            }
            // 往返回值列表添加数据
            //noinspection unchecked
            list.add(Arrays.asList((T[]) filter));
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
            filter = new Object[count];
            numCount = 0;
        }

        return list;
    }

    public static <T, E> List<List<T>> specifiedGroup(final List<T> dataList,
                                                      List<List<E>> specifiedGroups, Function<T, E> transfer) {
        Map<E, List<T>> eListMap = dataList.stream()
                .collect(Collectors.groupingBy(transfer));
        return specifiedGroups.stream()
                .map(it -> it.stream()
                        .map(ele -> {
                            List<T> tList = eListMap.get(ele);
                            if (CollectionUtils.isEmpty(tList)) {
                                throw new IllegalArgumentException("无法找到目标参数值: " + Objects.toString(ele));
                            }
                            T targetEle = tList.get(0);
                            tList.remove(targetEle);    //去掉这个已经被选择的
                            return targetEle;
                        }).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    /**
     * 列出组合，但是不过滤
     *
     * @param dataSet
     * @param add
     * @param max
     * @param defaultVal
     * @param count
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>, R extends Comparable<R>> List<List<T>> listCombinesNotFilter(List<T> dataSet, BinaryOperator<T> add,
                                                                                                         T max, T defaultVal, int count) {
        return combine(dataSet, count);
    }

    /**
     * 判断string是否以某种String集合中的一个元素开始
     *
     * @param content  待比较的字符串
     * @param iterable 开头的字符集和
     */
    public static boolean isStartBySet(String content, Iterable<String> iterable) {
        //如果两者有一个是null，那么就返回false
        if (StringUtils.isEmpty(content) || iterable == null) return false;
        boolean isStart = false;
        for (String ele : iterable) {
            if (content.startsWith(ele)) {
                isStart = true;
                break;
            }
        }
        return isStart;
    }

    public static <T> void printMap(T[][] map) {
        for (T[] row : map) {
            for (T col : row) {
                System.out.print(String.format("%s\t", col.toString()));
            }
            System.out.println();
        }
    }

}