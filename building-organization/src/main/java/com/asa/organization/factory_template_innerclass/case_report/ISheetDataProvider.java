package com.asa.organization.factory_template_innerclass.case_report;

import java.util.Collections;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:27 2019/5/7.
 */
public interface ISheetDataProvider {
    default Map<String, Object> getTitle() throws Exception {
        return Collections.emptyMap();
    }

    int getCount() throws Exception;

    Map<String, Object> getData(int page) throws Exception;

    /**
     * 获取尾部参数
     *
     * @return Map<String , Object> 尾部参数
     * @throws Exception
     */
    default Map<String, Object> getTail() throws Exception {
        return Collections.emptyMap();
    }

    default int getPageSize(){
        return 1000;
    }
}