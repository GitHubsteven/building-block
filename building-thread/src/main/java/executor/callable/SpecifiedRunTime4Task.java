package executor.callable;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/24
 * @description: 指定线程池的线程运行时间，超时的话，那么就中断异常
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SpecifiedRunTime4Task {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Future<String>> futures = executor.invokeAll(Arrays.asList(new XTask("1"), new XTask("2"), new XTask("3"), new XTask("4")),
                10, TimeUnit.SECONDS);// Timeout of 10 seconds.
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }


    public static class XTask implements Callable<String> {
        private String id;

        public XTask(String id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            int sleepTimeS = RandomUtils.nextInt(8, 12);
            System.out.printf("task id: %s sleep(s):%d\n", id, 8);
            TimeUnit.SECONDS.sleep(sleepTimeS);
            return id;
        }
    }
}
