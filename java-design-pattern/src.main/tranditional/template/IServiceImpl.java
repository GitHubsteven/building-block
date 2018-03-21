package tranditional.template;

public class IServiceImpl extends AbstractService {
    @Override
    public void operate() {
        System.out.println("server is running operate in impl1");
    }

    @Override
    public void operate2() {
        System.out.println("server is runing operate2 in impl1");
    }
}
