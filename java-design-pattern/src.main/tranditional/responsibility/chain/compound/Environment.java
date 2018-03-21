package tranditional.responsibility.chain.compound;

import tranditional.responsibility.example2.AbstractIndivFilter;
import tranditional.responsibility.example2.FilterParam;

public class Environment {
    public static void main(String[] args) {
        FilterParam param = new FilterParam().setId(22L);
//        IndivFilter chain = Chain.createClientOrderChain();
//        chain.check(param);
        AbstractIndivFilter head = new Chain.ClientOrderNumberCheckFilter();
        Chain chain = new Chain(head);
        chain.addFilter(new Chain.ClientOrderTrackingFilter().setLastFilter(true));
        chain.check(param);
    }
}
