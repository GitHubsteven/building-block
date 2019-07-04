package com.variety.shop.indi.report.codeStyle;

/**
 * Created by rongbin.xie on 2017/6/26.
 */
public class CodeStyle2 {

    public static void main(String[] args) {

    }
    static void selfController(String type,Param param) {
        switch (type){
            case "A":
                functionA(param);
                break;
            case "Source":
                functionB(param);
                break;
            case "C":
                functionC(param);
                break;
        }
    }

    static void functionA(Param a) {
        ResultFactory.createResult(new ICodeStyle() {
            @Override
            public Integer getData(Param param) {
                return a.getAge();
            }

            @Override
            public void step2(Integer a) {

            }
        });
    }

    static void functionB(Param b) {
        ResultFactory.createResult(new ICodeStyle() {
            @Override
            public Integer getData(Param param) {
                return b.getAge();
            }

            @Override
            public void step2(Integer a) {

            }
        });

    }

    static void functionC(Param c) {
        ResultFactory.createResult(new ICodeStyle() {
            Param param;

            {
                param =c;
            }

            @Override
            public Integer getData(Param param) {
                return c.getAge();
            }

            @Override
            public void step2(Integer a) {

            }
        });
    }


}
