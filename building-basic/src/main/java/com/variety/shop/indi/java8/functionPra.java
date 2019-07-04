package com.variety.shop.indi.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Created by rongbin.xie on 2017/12/26.
 */
public class functionPra {
    public static void main(String[] args) {
        //region localDate
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        assert count == 16;
        LocalDate now = LocalDate.now();
        LocalTime.now();
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        Date dateNow = new Date();
        System.out.println(dateNow.getTime());

        LocalDate birthdayWithYear = LocalDate.of(2011,1,12);
        MonthDay birthday = MonthDay.of(birthdayWithYear.getMonth(),birthdayWithYear.getDayOfMonth());
        //endregion

//        Clock clock = Clock.systemUTC();
//        ZoneId zone = clock.getZone();
//        System.out.println(zone);
//        System.out.println("Clock : " + clock);
//
//        Clock defaultClock = Clock.systemDefaultZone();
//        System.out.println("Clock : " + clock);
//
//        // Date and time with timezone in Java 8
//        ZoneId america = ZoneId.of("America/New_York");
//        LocalDateTime localtDateAndTime = LocalDateTime.now();
//        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
//        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);

        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
        Date dateN = Date.from(timestamp);
        Date nowD = new Date();
        System.out.println(dateN);
        System.out.println(nowD);
    }
}
