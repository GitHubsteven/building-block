package tranditional.bridge.indiv.example;

/**
 * bridge中相同的操作不同的composite，配置对象service来实现具体的service，老实说，我不明白为什么不采用对象注入方式来实现service的初始化
 * 即使调用了方法来获取service，但是结果仍然可能为空，只可能会导致错误，在实际开发或者高并发中，个人觉得这个例子不是很好。不如采用构造注入方式来。
 *
 */
public class Client {
    public static void main(String[] args) {
        IService service1 = new IServiceImpl1();
        Bridge bridge = new MyBridge();
        bridge.setService(service1);
        bridge.operate();
    }
}
