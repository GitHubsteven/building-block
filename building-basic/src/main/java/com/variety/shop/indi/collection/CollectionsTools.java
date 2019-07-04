package com.variety.shop.indi.collection;

import java.math.BigDecimal;

/**
 * Created by rongbin.xie on 2018/1/4.
 */
public class CollectionsTools {
    public static void main(String[] args) {
//        List<String> emptyList = new ArrayList();
//        String result = emptyList.stream().collect(Collectors.joining(","));
//        boolean notBlank = StringUtils.isNotBlank(result);
//        System.out.println(notBlank);
//        System.out.println(result);
//        boolean digit = Character.isDigit('5');
////        System.out.println(digit);
//        Float aFloat = Float.valueOf("1.2");
//        System.out.println(aFloat);
        BigDecimal time = new BigDecimal(200.000);
        System.out.println(time.stripTrailingZeros().toPlainString());
        System.out.println(booleanToInt(null));
    }

    public static int booleanToInt(Boolean b){
        return null != b &&  b ? 1 : 0;
    }
}
