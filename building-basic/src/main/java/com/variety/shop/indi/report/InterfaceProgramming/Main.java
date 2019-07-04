package com.variety.shop.indi.report.InterfaceProgramming;

/**
 * Created by rongbin.xie on 2017/5/26.
 */
public class Main {
    public static void main(String[] args) {
        Integer para = 10;
        Integer result = NumberOperFactory.dealTheData(para, new ICommonOper() {
            @Override
            public Integer add(Integer para) {
                if (null == para) return null;
                return para + 2;
            }

            @Override
            public Integer multi(Integer para) {
                if (null == para) return null;
                return para * 10;
            }

            @Override
            public Integer sub(Integer para) {
                if (null == para) return null;
                return para - 9;
            }
        });
        System.out.println(result);
    }
}
