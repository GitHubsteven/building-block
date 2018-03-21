package adaptor.Factory;

import adaptor.*;
import adaptor.unchangable.IServiceImpl1;

/**
 * static bean creator
 */
public class ParamCreator {

    public static Adaptor createAdaptor() {
        return new Adaptor();
    }

    public static WrapperAdapter createWrapAdaptor() {
        IService service = new IServiceImpl();
        return new WrapperAdapter(service);
    }

    public static IServiceImpl1 createIServiceImpl1(){
        return new  IServiceImpl1();
    }

    public static IServiceImpl2 createIServiceImpl2(){
        return new  IServiceImpl2();
    }
}
