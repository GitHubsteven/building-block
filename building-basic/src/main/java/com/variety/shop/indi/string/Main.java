package com.variety.shop.indi.string;

import com.sun.deploy.util.StringUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by rongbin.xie on 2017/9/12.
 */
public class Main {
    public static void main(String[] args) {
//        stringConcat();
//        String data ="1,2,3,,";
//        String[] arr = data.split(",");
//        System.out.println(arr.length);
//        System.out.println(Arrays.toString(arr));

//        String number = "123456789";
//        //闭开区间
//        System.out.println(number.substring(number.length()-1))
//          stringConcat();
        System.out.println(Objects.equals(null,null));
    }

    private static void stringConcat() {
        Set<String> sizes = new HashSet<>();
        sizes.add("1");
        sizes.add("2");
//        StringUtils.join
        System.out.println(StringUtils.join(sizes,","));
    }
}
