package adaptor;

import adaptor.Factory.ParamCreator;

public class EnvCtrl {
    //inject a the service
    public static void main(String[] args) {
        IService service1 = ParamCreator.createIServiceImpl1();
        IService service2 = ParamCreator.createIServiceImpl2();

        service1.operate1();
        service1.operate2();

        service2.operate1();
        service2.operate2();
    }
}
