package lambda.template.criteria;

import lambda.template.exception.ApplicationDenied;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 16:20 2018/5/8.
 */
@FunctionalInterface
public interface Criteria {
    void check() throws ApplicationDenied;
}
