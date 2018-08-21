package tranditional.proxy.dynamic_proxy.cblib_proxy;

import tranditional.proxy.static_proxy.IOrderService;
import tranditional.proxy.static_proxy.IOrderServiceImpl;

public class CGlibProxyTemplateTest {
    public static void main(String[] args) {
        IOrderService orderService = CGlibProxyTemplate.getInstance().getProxy(IOrderServiceImpl.class);
        orderService.importOrder();
    }
}
