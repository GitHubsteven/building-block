package com.variety.shop.indi.design.pattern.strategy;

import java.util.Collections;
import java.util.Map;

/**
 * Created by rongbin.xie on 2017/5/24.
 */
public interface ICreateReportStrategy {

    default Map<String, Object> getTitle() throws Exception {
        return Collections.emptyMap();
    }

    int getCount() throws Exception;

    Map<String, Object> getData(int page) throws Exception;

    /**
     * 获取尾部参数
     *
     * @return Map<String,Object> 尾部参数
     * @throws Exception
     */
    default Map<String, Object> getTail() throws Exception {
        return Collections.emptyMap();
    }

    int getPageSize();

}
