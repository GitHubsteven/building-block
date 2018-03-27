package lambda.template;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author asaland.xie
 * @Description:
 * @Date: Created at 22:26 2018/3/21.
 */
public abstract class LoadApplication {
    public void checkLoadApplication() throws Exception{
        checkId();
        checkIncomeHis();
        checkCreditHis();
        reportFindings();
    }

    abstract void checkId() throws Exception;
    abstract void checkIncomeHis() throws Exception;
    abstract void checkCreditHis() throws Exception;

    private void reportFindings(){

    };
}
