/**
 * @author: asx
 * @date: 2022/11/8
 * @descrition:
 */
package leetcode.sword.to.offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private static Lock lock = new ReentrantLock(true);
    private final Condition foo = lock.newCondition();
    private volatile boolean isFoo = true;

    private final int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!isFoo) {
                    foo.await();
                }
                printFoo.run();
                isFoo = false;
                foo.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            try {
                while (isFoo) {
                    foo.await();
                }
                printBar.run();
                isFoo = true;
                foo.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}