package com.demo.asa.building.proxy;

import com.demo.asa.building.proxy.bean.QueryBean;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IActionService {

    List<String> selectByPage(QueryBean queryBean);
}
