package pers.asa.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/5
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SyncStartIdMode {
    public static AtomicReference<String> startIdCache = new AtomicReference<>();


    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> {
            startIdCache.get();
        });
        startIdCache.getAndSet("");
    }


    protected void runWithThreadPool(List<Runnable> threads, int intThreadCount) throws InterruptedException {

        // 如果没有任务，则直接返回
        if (threads == null || threads.size() < 1) {
            System.out.println("No threads available for method [runWithThreadPool]");
            return;
        }

        ExecutorService pool = Executors.newFixedThreadPool(intThreadCount);

        threads.forEach(pool::execute);

        pool.shutdown();

        // 等待子线程结束，再继续执行下面的代码
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }
}
