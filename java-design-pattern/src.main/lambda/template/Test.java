package lambda.template;

import lambda.template.criteria.Criteria;
import lambda.template.exception.ApplicationDenied;
import lambda.template.role.Company;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 10:27 2018/5/9.
 */
public class Test {

    public static void receiveBlankFunction(Criteria criteria) {
        try {
            criteria.check();
        } catch (ApplicationDenied applicationDenied) {
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        Company company = new Company();

        receiveBlankFunction(company::checkCredit);
    }
}
