package com.variety.shop.indi.design.pattern.factory.calculateRule;

import java.util.Map;

/**
 * Created by rongbin.xie on 2017/10/16.
 */
public class CalculateSize implements ICalculateRule{

    /**
     * 获取当前用户
     *
     * @return
     */
    @Override
    public String currentName() {
        return "Size";
    }

    /**
     * 计算规则
     *
     * @param data 数据源
     * @return 计算结果
     */
    @Override
    public String calculate(Map<String, Object> data) {
        return (String) data.get(currentName());
    }

    /**
     * @since
     * @param data
     * @return
     */
    public String calculateWithSuffix(Map<String, Object> data){
        return null;
    }
}
