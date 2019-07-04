package com.variety.shop.indi.design.pattern.factory.calculateRule;

import java.util.Map;

/**
 * Created by rongbin.xie on 2017/10/16.
 */
public interface ICalculateRule {
    /**
     * 获取当前用户
     *
     * @return
     */
    String currentName();

    /**
     * 计算规则
     *
     * @param data 数据源
     * @return 计算结果
     */
    String calculate(Map<String, Object> data);
}
