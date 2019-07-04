package com.variety.shop.indi.report.codeStyle;

/**
 * Created by rongbin.xie on 2017/6/26.
 */
public class CodeStyle {
    public static void main(String[] args) {

    }

    static void selfController() {

    }

    static void functionA(Param a) {
        Integer re = getAdata(a);
        outResult(re);
    }

    static void functionB(Param b) {
        Integer re = getBdata(b);
        outResult(re);
    }

    static void functionC(Param c) {
        Integer re = getCdata(c);
        outResult(re);
    }


    static Integer getAdata(Param param) {
        return 0;
    }

    static Integer getBdata(Param param) {
        return 0;
    }

    static Integer getCdata(Param param) {
        return 0;
    }


    static void outResult(Integer a) {
    }

}
