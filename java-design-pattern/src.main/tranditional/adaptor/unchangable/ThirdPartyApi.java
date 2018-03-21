package tranditional.adaptor.unchangable;

import java.io.Serializable;

/**
 * this is the design in 3rd  party for the out api, Now you can not change the code.
 */
public class ThirdPartyApi implements Serializable {
    public void outApi1(ThirdPartyParamBean param){

        param.operate1();
        param.operate2();
        param.operate3();
    }
}
