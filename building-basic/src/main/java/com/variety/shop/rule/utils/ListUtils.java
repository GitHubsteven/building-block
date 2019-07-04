package com.variety.shop.rule.utils;

import java.util.List;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public class ListUtils {
    /**
     * 此方法已经过时，请使用getLIstLength(XXX)
     *
     * @param list 数据源
     * @return 数据源长度
     */
    @Deprecated
    static int getListLength(List list) {
        return list.size();
    }
}
