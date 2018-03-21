package command.company.business;

import proxy.IOrderService;

/**
 * ctrl is a invoker, whose job is to send command, call the service to import a order, ctrl itself does not care how the service
 * to realize the business.
 */
public class OrderCtrl {
//    @AutoWired
    private IOrderService orderService;
    void saveOrder(){
        orderService.importOrder();
    }
}
