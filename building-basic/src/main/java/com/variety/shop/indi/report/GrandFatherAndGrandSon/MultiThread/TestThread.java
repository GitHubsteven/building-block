package com.variety.shop.indi.report.GrandFatherAndGrandSon.MultiThread;

/**
 * Created by dell on 2017/2/24.
 */
public class TestThread implements Runnable {
    private static int resultCode = 0;
    private Integer divident;
    private Integer dividor;

    public Integer getDivident() {
        return divident;
    }

    public void setDivident(Integer divident) {
        this.divident = divident;
    }

    public Integer getDividor() {
        return dividor;
    }

    public void setDividor(Integer dividor) {
        this.dividor = dividor;
    }

    public TestThread(Integer divident, Integer dividor) {
        this.divident = divident;
        this.dividor = dividor;
    }

    @Override
    public void run() {
        test();
        try {
            test();
        } catch (Exception e) {
            System.out.println("thread :    ");
            resultCode = 1;
        }finally {
            System.out.println(resultCode);
        }
    }

    public void test()
    {
        System.out.println(this.divident/this.dividor);
    }
}
