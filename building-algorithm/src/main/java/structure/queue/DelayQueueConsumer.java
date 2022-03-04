package structure.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/3/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
public class DelayQueueConsumer implements Runnable {
    private BlockingQueue<XDelayTask> queue;
    private Integer numberOfElementsToTake;
    public AtomicInteger numberOfConsumedElements = new AtomicInteger();

    public DelayQueueConsumer(BlockingQueue<XDelayTask> queue,
                              Integer numberOfElementsToTake) {
        this.queue = queue;
        this.numberOfElementsToTake = numberOfElementsToTake;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToTake; i++) {
            try {
                XDelayTask task = queue.take();
                numberOfConsumedElements.incrementAndGet();
                System.out.println("Consumer take: " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
