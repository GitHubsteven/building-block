package structure.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/24
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class DelayQueueTest {
    public static void main(String[] args) {
        List<XTask> xTasks = new ArrayList<>();

        DelayQueue<XTask> queue = new DelayQueue<>(xTasks);
    }

    public static class XTask implements Delayed {
        @Override
        public long getDelay(TimeUnit unit) {
            return 1;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
