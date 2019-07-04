    package com.variety.shop.indi.report.codeStyle;

    /**
     * Created by rongbin.xie on 2017/6/26.
     */
    public class ResultFactory {

        public static void createResult(ICodeStyle codeStype) {
            Param param = new Param();
            Integer result = codeStype.getData(param);
            codeStype.step2(result);
        }
    }
