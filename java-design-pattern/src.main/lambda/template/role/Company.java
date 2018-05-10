package lambda.template.role;

import lambda.template.exception.ApplicationDenied;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 10:11 2018/5/9.
 */
public class Company {
    public void checkIdentity() throws ApplicationDenied {
    }

    public void checkCredit() throws ApplicationDenied {
        System.out.println("check credit");
    }

    public void checkIncome() throws ApplicationDenied {
    }

}
