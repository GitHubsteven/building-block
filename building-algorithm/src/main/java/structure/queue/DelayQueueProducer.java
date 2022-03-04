package structure.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

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
public class DelayQueueProducer implements Runnable {
    private BlockingQueue<XDelayTask> queue;

    private Integer numberOfElement2Produce;

    private Integer delayOfEachElementInMs;

    public DelayQueueProducer(BlockingQueue<XDelayTask> queue,
                              Integer numberOfElement2Produce,
                              Integer delayOfEachElementInMs) {
        this.queue = queue;
        this.numberOfElement2Produce = numberOfElement2Produce;
        this.delayOfEachElementInMs = delayOfEachElementInMs;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfElement2Produce; i++) {
            XDelayTask task = new XDelayTask(UUID.randomUUID().toString(), delayOfEachElementInMs);
            System.out.println("put task: " + task);
            try {
                queue.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
