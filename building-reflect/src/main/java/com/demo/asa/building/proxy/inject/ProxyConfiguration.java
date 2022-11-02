package com.demo.asa.building.proxy.inject;

import com.demo.asa.building.proxy.IActionService;
import com.demo.asa.building.proxy.impl.DBActionServiceImpl;
import com.demo.asa.building.proxy.impl.OdpsActionServiceImpl;
import com.demo.asa.building.proxy.interceptor.ActionMethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/9
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Configuration
public class ProxyConfiguration {

    @Bean("ActionServiceProxy")
    IActionService actionServiceProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IActionService.class);
        enhancer.setCallback(actionMethodInterceptor());
        return (IActionService) enhancer.create();
    }
    @Bean
    DBActionServiceImpl dbActionService() {
        return new DBActionServiceImpl();
    }
    @Bean
    OdpsActionServiceImpl odpsActionService() {
        return new OdpsActionServiceImpl();
    }
    @Bean
    ActionMethodInterceptor actionMethodInterceptor() {
        return new ActionMethodInterceptor(dbActionService(), odpsActionService());
    }
}
