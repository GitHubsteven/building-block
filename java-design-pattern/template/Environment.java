package template;

import adaptor.unchangable.IServiceImpl1;

public class Environment {
    public static void main(String[] args) {
        IService service = new IServiceImpl();
        service.commonOper();
        service.commonOper2();
        service.operate();
        service.operate2();
    }
}
