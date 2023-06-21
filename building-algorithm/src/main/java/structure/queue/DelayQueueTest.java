package structure.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/24
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<XDelayTask> queue = new DelayQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(2);


        int numberOfElementsToProduce = 2;
        int delayOfEachProducedMessageMilliseconds = 500;

        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer = new DelayQueueProducer(
                queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        // when
        executor.submit(producer);
        executor.submit(consumer);

        // then
        boolean isSuccess = executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();

        assertEquals(consumer.numberOfConsumedElements.get(), numberOfElementsToProduce);
    }


}
