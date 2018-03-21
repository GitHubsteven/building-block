package tranditional.proxy;

public class IOrderServiceImplProxy implements IOrderService{
    /*you can inject it in spring */
    private IOrderService serviceImpl;

    public IOrderServiceImplProxy(IOrderService serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Override
    public void importOrder() {
        /*
        * three functions are independent totally, and something have to be solved if want extend this pattern's usage.
        * */
        checkOrderInfo();
        serviceImpl.importOrder();
        importOrderDec();
    }

    public boolean checkOrderInfo(){
        System.out.println("Before importing orders, server is checking order info ...");
        return true;
    }

    public void importOrderDec(){
        System.out.println("After import orders, server is importing order declare...");
    }
}
