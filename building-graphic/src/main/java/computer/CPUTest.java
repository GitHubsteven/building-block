package computer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/10
 * @Time: 17:41
 * @Description: CPU使用率其实就是你运行的程序占用的CPU资源，表示你的机器在某个时间点的运行程序的情况。
 * @version: 1.0.0
 */
public class CPUTest {
    public static void main(String[] args) {
        // 开始时间
        long startTime = 0;
        // 繁忙时间
        int busyTime = 10;
        // 空闲时间
        int idleTime = 10;
        while (true) {
            startTime = System.currentTimeMillis();
            // CPU繁忙
            while (System.currentTimeMillis() - startTime <= busyTime) ;
            // CPU空闲
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
