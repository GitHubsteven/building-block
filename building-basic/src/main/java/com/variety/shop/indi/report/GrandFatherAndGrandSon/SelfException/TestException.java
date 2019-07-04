package com.variety.shop.indi.report.GrandFatherAndGrandSon.SelfException;

/**
 * Created by dell on 2017/2/17.
 */
public class TestException {

    public void testException(Integer type) throws Exception
    {
          /*  if( null == type)
            {
                throw  new SelfException("parameter is null");
            }*/
    }


    public static void main(String[] args) {
        TestException test = new TestException();
        try {
            test.testException(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
