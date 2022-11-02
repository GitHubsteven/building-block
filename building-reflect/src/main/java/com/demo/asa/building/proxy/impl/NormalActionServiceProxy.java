package com.demo.asa.building.proxy.impl;

import com.demo.asa.building.proxy.IActionService;
import com.demo.asa.building.proxy.bean.QueryBean;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/9
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class NormalActionServiceProxy implements IActionService {
    private final DBActionServiceImpl dbActionService;
    private final OdpsActionServiceImpl odpsActionService;

    public NormalActionServiceProxy(DBActionServiceImpl dbActionService,
                                    OdpsActionServiceImpl odpsActionService) {
        this.dbActionService = dbActionService;
        this.odpsActionService = odpsActionService;
    }

    @Override
    public List<String> selectByPage(QueryBean queryBean) {
        boolean enableMc = queryBean.enableMc();
        return enableMc ? odpsActionService.selectByPage(queryBean)
                : dbActionService.selectByPage(queryBean);
    }
}
