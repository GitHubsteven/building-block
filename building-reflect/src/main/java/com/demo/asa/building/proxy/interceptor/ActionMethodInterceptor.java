package com.demo.asa.building.proxy.interceptor;

import com.demo.asa.building.IEnableMC;
import com.demo.asa.building.proxy.impl.DBActionServiceImpl;
import com.demo.asa.building.proxy.impl.OdpsActionServiceImpl;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ActionMethodInterceptor implements MethodInterceptor {
    private final DBActionServiceImpl dbActionService;
    private final OdpsActionServiceImpl odpsActionService;

    public ActionMethodInterceptor(DBActionServiceImpl dbActionService,
                                   OdpsActionServiceImpl odpsActionService) {
        this.dbActionService = dbActionService;
        this.odpsActionService = odpsActionService;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        boolean isMc = false;
        Optional<Object> any = Stream.of(params)
                .filter(it -> it instanceof IEnableMC)
                .findAny();
        if (any.isPresent()) {
            isMc = ((IEnableMC) any.get()).enableMc();
        }
        return isMc ? methodProxy.invoke(odpsActionService, params)
                : method.invoke(dbActionService, params);
    }
}
