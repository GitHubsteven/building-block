package adaptor;

public class IServiceImpl implements IService {
    @Override
    public void operate1() {
        System.out.println("this server operation changes 1 ...");
    }

    @Override
    public void operate2() {
        System.out.println("this server operation changes 2...");
    }
}
