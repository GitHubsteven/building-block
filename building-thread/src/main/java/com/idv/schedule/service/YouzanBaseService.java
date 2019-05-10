package com.idv.schedule.service;


import util.DateTimeUtils;

import java.util.Date;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 18:49 2019/5/9.
 */
public class YouzanBaseService {
    public static void doAutoRefresh() {
        System.out.println(DateTimeUtils.format(new Date(), DateTimeUtils.DEFAULT_DATETIME_FORMAT) + ":------------>doAutoRefresh");
    }
}