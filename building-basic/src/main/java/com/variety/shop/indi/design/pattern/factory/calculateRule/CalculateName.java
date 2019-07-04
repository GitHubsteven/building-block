package com.variety.shop.indi.design.pattern.factory.calculateRule;

import java.util.Map;

/**
 * Created by rongbin.xie on 2017/10/16.
 */
public class CalculateName implements ICalculateRule {
    /**
     * 获取当前用户
     *
     * @return <String> 当前用户</String>
     */
    @Override
    public String currentName() {
        return "name";
    }

    @Override
    public String calculate(Map<String, Object> data) {
        return (String) data.get(currentName());
    }
}
