package lambda.template;

import lambda.template.criteria.Criteria;
import lambda.template.exception.ApplicationDenied;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 16:21 2018/5/8.
 */
public class LoanFlow {
    private final Criteria identity;
    private final Criteria creditHis;
    private final Criteria incomeHis;

    public LoanFlow(Criteria identity, Criteria creditHis, Criteria incomeHis) {
        this.identity = identity;
        this.creditHis = creditHis;
        this.incomeHis = incomeHis;
    }

    public void checkLoadFlow() throws ApplicationDenied {
        identity.check();
        creditHis.check();
        incomeHis.check();
        reportFinding();
    }

    private void reportFinding() {

    }
}
