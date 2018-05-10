package tranditional.responsibility.example;

/**
 * 为什么不在这里实现handler定义的operate方法呢？因为我们想在这里只是实现公共的方法，具体的实现逻辑在具体的handler中实现，
 * 为什么这里有模板设计思想呢？
 */
public abstract class AbstractHandler implements Handler {
    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public AbstractHandler setSuccessor(Handler successor) {
        this.successor = successor;
        return this;
    }
}
