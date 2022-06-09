package com.demo.asa.building.proxy.impl;

import com.demo.asa.building.proxy.IActionService;
import com.demo.asa.building.proxy.bean.QueryBean;

import java.util.Collections;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class OdpsActionServiceImpl implements IActionService {

    @Override
    public List<String> selectByPage(QueryBean queryBean) {
        return Collections.singletonList("odps");
    }
}
