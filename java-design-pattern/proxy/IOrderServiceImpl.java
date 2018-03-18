package proxy;

/**
 * Following is the illustration of the command pattern
 *
 * you can treat it as a receiver in command pattern. It does not have direct relation with the order ctrl and is independent
 * even it is name as orderServiceImpl.
 *
 * In other word, The command pattern exists commonly in spring framework. if you separate the request and response and the production
 * for this, you can treat it as command pattern usage.
 */
public class IOrderServiceImpl implements  IOrderService{

    @Override
    public void importOrder() {
        System.out.println("server is importing order ...");
    }
}
