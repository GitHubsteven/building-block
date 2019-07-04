package com.variety.shop.indi.list;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 关于测试类list分组和分组之后的多线程
 * <p>
 * Created by rongbin.xie on 2017/9/4.
 */
public class listPartition {
    public static void main(String[] args) {
        partitionList();
//        callableTest();
    }

    private static void partitionList() {
        List<Data> dataList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            dataList.add(new Data("name" + i, i));
            list.add(i);
        }
        List<List<Data>> lists = partitionList(dataList, 10);
        if (CollectionUtils.isEmpty(lists)) {
            return;
        }
        List<Runnable> threads = new ArrayList<>();
        lists.forEach(System.out::println);
        lists.forEach(datas -> threads.add(() -> datas.forEach(System.out::println)));
        threads.forEach(thread -> new Thread(thread).start());
    }

    private static void callableTest() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 0;
            }
        };
        try {
            Integer call = callable.call();
            System.out.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 分线程运行一组数据
     *
     * @param dataGroup
     * @param <T>
     */
    public static <T> void mulThreads(List<List<T>> dataGroup) {
        List<Runnable> threads = new ArrayList<>();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        runWithThreadPool();
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


}

class Data {
    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private Integer age;

    public Data(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
