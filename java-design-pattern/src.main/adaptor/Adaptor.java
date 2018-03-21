package adaptor;

import adaptor.unchangable.ThirdPartyParamBean;

/**
 * adapter the 3rd party api to call the operate
 */
public class Adaptor extends IServiceImpl implements ThirdPartyParamBean {

    @Override
    public void operate3() {
        System.out.println("this server operates 3 ...");
    }
}
