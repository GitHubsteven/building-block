package lambda.template;

import lambda.template.criteria.Criteria;
import lambda.template.role.Company;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 10:13 2018/5/9.
 */
public class CompanyLoanFlow extends LoanFlow {

    CompanyLoanFlow(Company company) {
        super(company::checkIdentity, company::checkCredit, company::checkIncome);
    }


    public CompanyLoanFlow(Criteria identity, Criteria creditHis, Criteria incomeHis) {
        super(identity, creditHis, incomeHis);
    }
}
