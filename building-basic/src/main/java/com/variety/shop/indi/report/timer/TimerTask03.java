package com.variety.shop.indi.report.timer;

import java.util.*;

/**
 * Created by rongbin.xie on 2017/5/9.
 */
public class TimerTask03 {
    Timer timer;

    public TimerTask03(){
        timer = new Timer();
        timer.schedule(new TimerTaskTest03(),1000,2000);
    }

    public static void main(String[] args) {
        new TimerTask03();
    }
}
class TimerTaskTest03 extends TimerTask{

    @Override
    public void run() {
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println("time to perform this thread is :" + date);

        List<Integer>  list = new ArrayList<>();
        for(int i =0;i<100;i++){
            i = i+1;
            i = i-1;
            i=i*i;
            list.add(i);
        }
        Integer sum = list.stream()
                .mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
