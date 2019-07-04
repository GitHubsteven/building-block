package com.variety.shop.indi.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 16:20 2018/4/16.
 */
public class ThreadDebug {
    public static void main(String[] args) throws InterruptedException {
//        new Thread() { // 断点0
//            @Override
//            public void run() {
//                System.out.println("1"); // 断点1
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("2"); // 断点2
//            }
//        }.start();
//        // 外线程
//        System.out.println("3"); // 断点3
//        Thread.sleep(2000);
//        System.out.println("4"); // 断点4
//    }
        List<Runnable> threads = new ArrayList<>();
        Thread thread = new MyThread("name1");
        Thread thread2 = new MyThread("name2");
        thread.start();
        thread2.start();

    }

    public static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(getName() + "output" + i);
                if (i == 3) {
                    try {
                        System.out.println(getName() + "sleep 2000ms");
                        this.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
