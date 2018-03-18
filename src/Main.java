import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }

        };
        task.scheduledExecutionTime();
        task.run();
    }
}
