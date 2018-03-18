package adaptor;

import adaptor.IServiceImpl;
import adaptor.unchangable.ThirdPartyParamBean;

public class WrapperAdapter implements ThirdPartyParamBean {
    private IService iService;

    public WrapperAdapter(IService iService) {
        this.iService = iService;
    }

    @Override
    public void operate1() {
        iService.operate1();
    }

    @Override
    public void operate2() {
        iService.operate2();
    }

    @Override
    public void operate3() {
        System.out.println("adaptor operate 3 ...");
    }
}
