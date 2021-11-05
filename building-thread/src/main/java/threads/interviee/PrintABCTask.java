package threads.interviee;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Authoer: asa.x
 * @Date: 2021/11/5
 * @Descrition:
 */
public class PrintABCTask extends Thread {
    //    private static ReentrantLock lock = new ReentrantLock(true);
    private static final Object lock = new Object();
    private static String current = "A";

    /**
     * 私有字段
     */
    private String value;

    public PrintABCTask(String name, String value) {
        super(name);
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ) {
            synchronized (lock) {
                // 条件判断通过while，而不是if，但是用if通常好像也没出现过问题
                while (current.equalsIgnoreCase(value)) {
                    System.out.printf("%s:%s\t", getName(), value);
                    current = next(current);
                    i++;
                }
                lock.notifyAll();
            }
        }
    }

    private static String next(String current) {
        switch (current) {
            case "A":
                return "B";
            case "B":
                return "C";
            case "C":
                return "A";
        }
        throw new RuntimeException("invalid params:" + current);
    }
}
