package com.variety.shop.indi.report.codeStyle;

/**
 * Created by rongbin.xie on 2017/6/26.
 */
public interface ICodeStyle {
    default  Integer getData(Param param){
        return 0;
    }

    void step2(Integer a);
}
