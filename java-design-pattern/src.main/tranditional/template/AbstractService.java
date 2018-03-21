package tranditional.template;

/**
 * 利用task abstract 类，我们可以定义共同的方法，而我们同时可以定义或这重写，最后实现自己的业务，client根据自己的场景
 * 来创建实例，最后，在同一的接口下实现不同的业务，好熟悉！
 */
public abstract class AbstractService implements  IService {

    @Override
    public void commonOper() {
        System.out.println("server is running common operation1 ...");
    }


    @Override
    public void commonOper2() {
        System.out.println("server is running common operation2 ...");
    }
}
