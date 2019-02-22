package com.asa.building.optimize.inherit;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 继承和ThreadLocal 的一个小case
 * @Date: Created at 19:04 2019/2/21.
 */
public class MethodShareService {
    private static MethodShare methodShare = new MethodShare();

    public static void main(String[] args) {
        new MethodShareService().execute();
    }

    public void execute() {
        List<Thread> runnables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            runnables.add(new ShareThread(i));
        }

        runnables.forEach(Thread::start);
    }


    public class ShareThread extends Thread {
        private Integer seq;

        public ShareThread(int i) {
            this.seq = i;
        }

        @Override
        public void run() {
            String name = "name" + seq;
            try {
                //普通的对象
                methodShare.getPerson().setName(name);
                //threadLocal
                methodShare.getPersonThreadLocal().get().setName(name);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = String.format("name:%s,common name after sleep:%s, thread local name after sleep:%s", name, methodShare.getPerson().getName(),
                    methodShare.getPersonThreadLocal().get().getName());
            System.out.println(result);
        }
    }


    private void action(int i) {
        String name = "name" + i;
        Person p = new Person();
        p.setName(name);
        methodShare.setPerson(p);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name.equals(methodShare.getPerson().getName()));
    }
}