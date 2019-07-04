package com.variety.shop.indi.report.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by rongbin.xie on 2017/5/9.
 */
public class ScheduleTest {
    Timer timer;

    public ScheduleTest(int time){
        timer = new Timer();
        timer.schedule(new TimerTaskTest01(),time*1000);
    }

    public static void main(String[] args) {
        System.out.println("timer begin ...");
        new ScheduleTest(3);
    }
}

class TimerTaskTest01 extends TimerTask{

    @Override
    public void run() {
        System.out.println("time is up!!");
    }
}
