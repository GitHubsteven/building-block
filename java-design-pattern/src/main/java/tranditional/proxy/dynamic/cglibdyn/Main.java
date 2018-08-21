package tranditional.proxy.dynamic.cglibdyn;

import tranditional.proxy.IOrderService;
import tranditional.proxy.IOrderServiceImpl;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/16
 * @Time: 18:38
 * @Description:
 * @version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        IOrderServiceImpl orderProxy = CGlibProxy.instance().getProxy(IOrderServiceImpl.class);
        orderProxy.importOrder();
    }
}