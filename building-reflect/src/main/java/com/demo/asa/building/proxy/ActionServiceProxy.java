package com.demo.asa.building.proxy;

import com.demo.asa.building.proxy.bean.QueryBean;
import com.demo.asa.building.proxy.impl.DBActionServiceImpl;
import com.demo.asa.building.proxy.impl.OdpsActionServiceImpl;
import com.demo.asa.building.proxy.interceptor.ActionMethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ActionServiceProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IActionService.class);
        DBActionServiceImpl dbActionService = new DBActionServiceImpl();
        OdpsActionServiceImpl odpsActionService = new OdpsActionServiceImpl();
        enhancer.setCallback(new ActionMethodInterceptor(dbActionService, odpsActionService));
        IActionService iActionService = (IActionService) enhancer.create();
        QueryBean queryBean = new QueryBean();
        queryBean.setNo("001");
        System.out.println(String.join(",", iActionService.selectByPage(queryBean)));
        queryBean.setNo("mc-001");
        System.out.println(String.join(",", iActionService.selectByPage(queryBean)));
    }
}
