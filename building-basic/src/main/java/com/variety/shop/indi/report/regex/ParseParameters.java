package com.variety.shop.indi.report.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rongbin.xie on 2017/6/9.
 */
public class ParseParameters {
    public static void main(String[] args) {
        String parameters = "[17-06-01 16:20:33.878] ce.core.dao.wms.WmsBtStoreStockBookDao.selectCount[DEBUG]:181  | " +
                "==> Parameters: 1(Integer), 001(String), null";

        List<Para> paraList = new ArrayList<>();

        String reg = "[ ]+[\\S]+[)]+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(parameters);
        while (matcher.find()) {
            Para paraBean = new Para();
            String para = matcher.group();
            int leftIndex = para.indexOf("(");
            int rightIndex = para.indexOf(")");
            String dataType = para.substring(leftIndex + 1, rightIndex);
            String value = para.substring(0, leftIndex);
            paraBean.setDataType(dataType);
            paraBean.setValue(value);
            paraList.add(paraBean);
        }

        String mysql = "[17-06-01 16:20:33.876] ce.core.dao.wms.WmsBtStoreStockBookDao.selectCount[DEBUG]:181  " +
                "| ==>  Preparing: select count(*) from wms_bt_store_stock_book_s1 WHERE `store_id` = ? and `channel_id` = ? and `sku` = ? ";
        String[] sqlArray = mysql.split("Preparing: ");
        String mysqlWithPlaceHolder;
        if (sqlArray.length > 1) {
            mysqlWithPlaceHolder = sqlArray[1];
        } else {
            mysqlWithPlaceHolder = sqlArray[0];
        }

        Pattern pattern1 = Pattern.compile("\\?");
        Matcher matcher1 = pattern1.matcher(mysqlWithPlaceHolder);
        int count = 0;
        while (mysqlWithPlaceHolder.indexOf("?") > 0) {
            if (count < paraList.size()) {
                Para para = paraList.get(count++);
                mysqlWithPlaceHolder = mysqlWithPlaceHolder.replaceFirst("\\?","String".equals(para.getDataType()) ?
                        ("'" + para.getValue() + "'").replace(" ",""): (String) para.getValue());
            } else {
                mysqlWithPlaceHolder = mysqlWithPlaceHolder.replaceFirst("\\?", "null");
            }
        }
        System.out.println(mysqlWithPlaceHolder);


//        while (matcher1.find()) {
//            if (count < paraList.size()) {
//                Para para = paraList.get(count);
//                mysqlWithPlaceHolder = mysqlWithPlaceHolder.replaceFirst(matcher1.group(0), para.getDataType() != null ?
//                        "'" + para.getValue() + "'" : (String) para.getValue());
//            } else {
//                mysqlWithPlaceHolder = mysqlWithPlaceHolder.replace(matcher1.group(), "null");
//            }
//            count++;
//        }

    }

    static class Para {
        String dataType;
        Object value;

        Para() {
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Para(String dataType, String value) {
            this.dataType = dataType;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Para{" +
                    "dataType='" + dataType + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
