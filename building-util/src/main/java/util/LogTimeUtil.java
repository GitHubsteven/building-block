package util;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:19 2019/1/11.
 */
public class LogTimeUtil {
    public static long logTime(int loop, Runnable task) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            task.run();
        }
        return System.currentTimeMillis() - start;
    }
}