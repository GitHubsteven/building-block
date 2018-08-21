package tranditional.proxy.dynamic.jdkdyn;

import tranditional.proxy.IOrderService;
import tranditional.proxy.IOrderServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/16
 * @Time: 17:16
 * @Description:
 * @version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        IOrderService orderService = new IOrderServiceImpl();

        DynamicProxy dynamicProxy= new DynamicProxy(orderService);
        IOrderService orderServiceProxy = (IOrderService) Proxy.newProxyInstance(orderService.getClass().getClassLoader(), orderService.getClass().getInterfaces(), dynamicProxy);
        orderServiceProxy.importOrder();
    }
}