package com.idv.schedule;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.idv.schedule.service.YouzanBaseService;
import util.DateTimeUtils;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 18:47 2019/5/9.
 */
public class ScheduleTest {
    private static ScheduledExecutorService REFRESH_TOKEN_ES =
            Executors.newScheduledThreadPool(3, new ThreadFactoryBuilder().setNameFormat("youzan-token-refresh-pool-%d")
                    .setDaemon(true).build());

    public static void main(String[] args) {
        System.out.println(DateTimeUtils.format(new Date(), DateTimeUtils.DEFAULT_DATETIME_FORMAT) + ":---------->start");
        new TestThread(2, "sleep-2-thread").start();
//        new TestThread(5, "sleep-5-thread").start();
        REFRESH_TOKEN_ES.scheduleAtFixedRate(YouzanBaseService::doAutoRefresh, 1, 5, TimeUnit.SECONDS);
//        REFRESH_TOKEN_ES.shutdown();
    }

    static class TestThread extends Thread {
        private int sleepMin;

        TestThread(int sleepMin, String name) {
            this.sleepMin = sleepMin;
            super.setName(name);
        }

        @Override
        public void run() {
            System.out.println(String.format("%s:--------->%s", Thread.currentThread().getName(), "is going sleep for " + sleepMin + "min " +
                    "and daemon thread should not die"));
            try {
                Thread.sleep(1000 * 60 * sleepMin);
            } catch (InterruptedException e) {
                throw new RuntimeException("user thread sleep exception!");
            }
            System.out.println(String.format("%s:--------->%s", Thread.currentThread().getName(), "end sleep " +
                    "and daemon thread should dying expect there is other thread exists"));
        }
    }
}