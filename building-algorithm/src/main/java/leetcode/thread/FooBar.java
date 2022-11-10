package leetcode.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/11/8
 * @description https://leetcode-cn.com/problems/print-foobar-alternately/
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
class FooBar {
    private static final Lock lock = new ReentrantLock(true);
    private volatile boolean isFoo = true;

    private final int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            try {
                while (isFoo) {
                    printFoo.run();
                    isFoo = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                while (!isFoo) {
                    printBar.run();
                    isFoo = true;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}