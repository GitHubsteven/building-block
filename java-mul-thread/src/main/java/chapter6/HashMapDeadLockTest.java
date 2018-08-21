package chapter6;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/9
 * @Time: 12:31
 * @Description:
 * @version: 1.0.0
 */
public class HashMapDeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> hashMap = new HashMap<>(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            hashMap.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");

        thread.start();
        thread.join();
    }
}