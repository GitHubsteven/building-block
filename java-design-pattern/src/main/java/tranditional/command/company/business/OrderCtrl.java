package tranditional.command.company.business;

import tranditional.proxy.IOrderService;

/**
 * ctrl is a invoker, whose job is to send tranditional.command, call the service to import a order, ctrl itself does not care how the service
 * to realize the business.
 */
public class OrderCtrl {
//    @AutoWired
    private IOrderService orderService;
    void saveOrder(){
        orderService.importOrder();
    }
}
