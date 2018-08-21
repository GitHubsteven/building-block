package tranditional.proxy.static_proxy;

/**
 * Following is the illustration of the tranditional.command pattern
 *
 * you can treat it as a receiver in tranditional.command pattern. It does not have direct relation with the order ctrl and is independent
 * even it is name as orderServiceImpl.
 *
 * In other word, The tranditional.command pattern exists commonly in spring framework. if you separate the request and response and the production
 * for this, you can treat it as tranditional.command pattern usage.
 */
public class IOrderServiceImpl implements  IOrderService{

    @Override
    public void importOrder() {
        System.out.println("server is importing order ...");
    }
}
