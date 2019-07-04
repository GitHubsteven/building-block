package com.variety.shop.indi.report.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by rongbin.xie on 2017/5/9.
 */
public class TimeTask02 {
    Timer timer;

    public TimeTask02(){
        Date time = getTime();
        System.out.println("assigned time = "+time);
        timer = new Timer();
        timer.schedule(new TimerTaskTest02(),time);
    }
    public Date getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,5);
        calendar.set(Calendar.MINUTE,49);
        calendar.set(Calendar.SECOND,00);
        Date time = calendar.getTime();
        return time;
    }

    public static void main(String[] args) {
        new TimeTask02();
    }
}

class TimerTaskTest02 extends TimerTask {

    @Override
    public void run() {
        System.out.println("指定时间执行线程任务...");
    }
}
