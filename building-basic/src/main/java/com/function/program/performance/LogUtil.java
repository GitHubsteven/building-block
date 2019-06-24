package com.function.program.performance;

import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 14:30 2018/5/14.
 */
public class LogUtil {
    public static long logTime(int operateTimes, Consumer<String> supplier, String conduct) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < operateTimes; i++) {
            supplier.accept(conduct);
        }
        long end = System.currentTimeMillis();

        long runTime = end - start;
        System.out.println("运行时间(ms)：" + runTime);
        return runTime;
    }

}
