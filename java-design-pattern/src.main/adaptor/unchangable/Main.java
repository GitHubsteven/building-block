package adaptor.unchangable;

import adaptor.Adaptor;
import adaptor.Factory.ParamCreator;

public class Main {

    public static void main(String[] args) {

        ThirdPartyApi thirdPartyApi = new ThirdPartyApi();
        /*first adaptor : adaptor is a source class*/
        Adaptor adaptor = ParamCreator.createAdaptor();
        thirdPartyApi.outApi1(adaptor);

        /*second realize method, adapter has a source class*/

        thirdPartyApi.outApi1(ParamCreator.createWrapAdaptor());
    }
}
