package tranditional.proxy.static_proxy;

public class Main {
    public static void main(String[] args) {
        IOrderService source = new IOrderServiceImpl();
        IOrderService proxy = new IOrderServiceImplProxy(source);
        proxy.importOrder();
    }
}
