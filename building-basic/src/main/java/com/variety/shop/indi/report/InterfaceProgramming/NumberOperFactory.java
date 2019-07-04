package com.variety.shop.indi.report.InterfaceProgramming;

/**
 * Created by rongbin.xie on 2017/5/26.
 */
public class NumberOperFactory {
    public static Integer dealTheData(Integer original, ICommonOper oper) {
        Integer result = oper.add(original);
        Integer result1 = oper.sub(result);
        Integer target = oper.multi(result1);
        return target;
    }
}
