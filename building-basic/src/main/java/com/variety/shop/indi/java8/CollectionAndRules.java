package com.variety.shop.indi.java8;

import com.variety.shop.indi.report.Streams.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * multiply filter
 * <p>
 * Created by rongbin.xie on 2018/1/25.
 */
public class CollectionAndRules {
    public static void main(String[] args) {
        List<Person> persons = IntStream.range(1, 10).mapToObj(i -> {
            Person person = new Person();
            person.setName("Name" + i)
                    .setAge(i)
                    .setSex(i % 2)
                    .setSharp("" + i)
                    .setStudent(i % 2 == 1);
            return person;
        }).collect(Collectors.toList());
        Person single = new Person("jack", 12, 1);
        Predicate<Person> rule1 = Person::getStudent;
        Predicate<Person> rule2 = person -> person.getSex() == 1;
//        Predicate<Person> negate = rule2.negate();
//        System.out.println(negate.test(persons.get(1)));

        Predicate<Person> rule3 = person -> Objects.equals(person.getName(), "Name1");
        List<Predicate<Person>> rules = new ArrayList<>();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        long start = System.currentTimeMillis();
//        System.out.println(start);
//        List<Person> newPersons2 = filterUsingPredicate(persons, rules);
//        List<Person> newPersons = customFilter(persons, rules);
//        List<Person> personList = customFilter(single,persons, rule1);
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println("newPersons.size: " + newPersons.size());
//        System.out.println("newPersons2.size: " + newPersons2.size());
//        System.out.println(newPersons.get(0));
//        System.out.println(newPersons2.get(0));
//        runWithTime(CollectionAndRules::customFilter, persons);

    }

    /**
     * 根据过滤规则过滤集合
     *
     * @param collection 数据集合
     * @param mappers    规律规则
     * @param <I>        数据类型
     * @return 过滤后的数据集合
     */
    private static <I> List<I> customFilter(Collection<I> collection, List<Predicate<I>> mappers) {
        Stream<I> iStream = collection.stream();
        return iStream.filter(ele -> {
            int compareSum = mappers.stream()
                    .mapToInt(mapper -> mapper.test(ele) ? 1 : 0).sum();
            return compareSum == mappers.size();
        }).collect(Collectors.toList());
    }

    /**
     * 根据过滤规则过滤集合
     *
     * @param collection 数据集合
     * @param mappers    规律规则
     * @param <I>        数据类型
     * @return 过滤后的数据集合
     */
    private static <I> List<I> filterUsingPredicate(Collection<I> collection, List<Predicate<I>> mappers) {
        return collection.stream()
                .filter(ele -> mappers.stream()
                        .reduce(t -> true, Predicate::and)
                        .test(ele)).collect(Collectors.toList());
    }

    /**
     * 自定义过滤器
     *
     * @param collection 数据集合
     * @param predicate  过滤器
     * @param <S>        参数类型
     * @return 过滤后结果
     */
    public static <S> List<S> customFilter(S s, List<S> collection, Predicate<S> predicate) {
        List<S> initial = new ArrayList<S>();
        initial.add(s);
        return collection.stream().reduce(initial, (List<S> acc, S ele) -> {
            if (predicate.test(ele)) {
                List<S> newAcc = new ArrayList<S>(acc);
                newAcc.add(ele);
                return newAcc;
            } else {
                return acc;
            }
        }, (List<S> left, List<S> right) -> {
            System.out.println(left);
            System.out.println(right);
            List<S> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });

    }

    public <T> void functionProxyWithTime(Function<T, T> function, T collection) {
        long start = System.currentTimeMillis();
        function.apply(collection);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static <S> void runWithTime(Method method, S source) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        method.invoke(new CollectionAndRules(), source);
        System.out.println(System.currentTimeMillis() - start);
    }

}
