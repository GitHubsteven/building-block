package com.variety.shop.indi.report.slqParseTool;

import java.util.List;

/**
 * Created by rongbin.xie on 2017/6/1.
 */
public interface IStringParseTool {
    /**
     * 获取占位符的所在sql的位置
     *
     * @param originalSql sql源 <String>
     * @param placeHolder 占位符<String>
     * @return List<Integer>
     */
    List<Integer> getPlaceHolderIndex(String originalSql, String placeHolder);

    /**
     * 获取sql参数值
     *
     * @param parameterStr sql参数源
     * @return List<Object>
     */
    List<Object> getParametters(String parameterStr, String regex);

    /**
     * 获取最终的sql
     *
     * @param originalSql sql源
     * @param placeHolderIndex 占位符所在位置List<Integer>
     * @param parameters 参数List<Object>
     * @return 最终sql
     */
    String getTheSql(String originalSql, List<Integer> placeHolderIndex, List<Object> parameters);
}
