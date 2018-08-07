package threads;

public class FieldInThreads {
    public static void main(String[] args) {
        FieldInThreads test = new FieldInThreads();
        test.runThread();
    }

    private void runThread() {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new MyThread("" + i));
            thread.start();
        }
    }

    class MyThread implements Runnable {
        private CustomValue val = new CustomValue();
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
//            System.out.println("thread: " + name + "start run........");
            while (val.value > 0) {
                System.out.println("thread: " + name + "| count :" + val.value--);
            }
//            System.out.println("thread: " + name + "end run........");
        }
    }

    static class CustomValue {
        Integer value = 5;

        public Integer getValue() {
            return value;
        }

        public CustomValue setValue(Integer value) {
            this.value = value;
            return this;
        }
    }
}
