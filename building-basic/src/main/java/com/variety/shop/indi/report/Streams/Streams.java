package com.variety.shop.indi.report.Streams;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by dell on 2017/2/14.
 */
public class Streams {
    private enum Status
    {
        OPEN,CLOSED
    }

    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
    static final SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMddhhmmss");

//    Task 类的定义，但是是static final
    private static final class Task
    {
        private final Status status;
        private final Integer points;

        Task(final Status status , final Integer points)
        {
            this.status = status;
            this.points = points;
        }
        public Integer getPoints()
        {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "status=" + status +
                    ", points=" + points +
                    '}';
        }
    }

    public static long testTime(String firstDay,String secondDay)
    {
        Long first = 0L;
        Long second =0L;
        try {
             first =sdf.parse(firstDay).getTime();
             second =sdf.parse(secondDay).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Long timeLess = first-second + 86400000;
//        System.out.println(timeLess);
        return timeLess;
    }

    public static void main(String[] args) {


        final Collection<Task> tasks= Arrays.asList(
                new Task(Status.OPEN,5),
                new Task(Status.OPEN,13),
                new Task(Status.CLOSED,8)
        );

        final long totalPointsOfOpenTasks = tasks.stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println("total points :" + totalPointsOfOpenTasks);
    }
}
