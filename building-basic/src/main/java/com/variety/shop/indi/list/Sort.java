package com.variety.shop.indi.list;

import com.variety.shop.rule.bean.Person;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 13:07 2018/5/17.
 */
public class Sort {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        Person person1= new Person();
        person1.setId(1);
        person1.setAge(100);

        Person person2 = new Person();
        person2.setAge(20);
        person2.setId(2);

        persons.add(person1);
        persons.add(person2);
        persons.sort(Comparator.comparing(Person::getAge));

        persons.forEach(it-> System.out.println(it.getId()));

        Vector<String> vector = new Vector<>();
//        vector.add()
        LinkedList<String> linkedList = new LinkedList<>();

        SoftReference<Vector<String>> sr = new SoftReference<>(vector);

        ReferenceQueue<LinkedList<String>> referenceQueue = new ReferenceQueue<>();
        PhantomReference<LinkedList<String>> phantomReference = new PhantomReference<>(linkedList,referenceQueue);
        phantomReference.get();
        WeakHashMap<String,String> cache = new WeakHashMap<>();
        cache.put("cache1","value1");
        int a = 100;
        a <<= 1;
        a >>= 2;
        System.out.println(a);

        Lock lock = new ReentrantLock();
        lock.lock();   //
        lock.unlock();
        lock.tryLock(10,TimeUnit.SECONDS);
        AbstractQueuedSynchronizer synchronizer = null;
    }
}
