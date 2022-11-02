package interviewee;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/11/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class PrintTask extends Thread {
    private static int count = 1;

    private static ReentrantLock lock = new ReentrantLock(true);

    public PrintTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (count < 100) {
            lock.lock();
            System.out.printf("%s:%d\n", getName(), count);
            count++;
            lock.unlock();
        }
    }
}
