package interviewee;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/11/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class PrintABCTask extends Thread {

    private static ReentrantLock lock = new ReentrantLock(true);
    //    private static final Integer lock = 1;
    private static volatile int count = 1;
    private static String current = "A";

    private final String value;

    public PrintABCTask(String name, String value) {
        super(name);
        this.value = value;
    }

    @Override
    public void run() {
        while (count <= 10) {
            try {
                lock.lock();
                while (current.equalsIgnoreCase(value)) {
                    System.out.printf("%s:%s\t", getName(), value);
                    current = next(current);
                    if ("C".equalsIgnoreCase(value)) {
                        count++;
                    }
                }
            } finally {
                lock.unlock();
            }
        }

    }

    public String next(String current) {
        switch (current) {
            case "A":
                return "B";
            case "B":
                return "C";
            case "C":
                return "A";
        }
        throw new IllegalArgumentException("非法参数：" + current);
    }
}
