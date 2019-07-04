package com.variety.shop.indi.overLoad;

/**
 * Created by rongbin.xie on 2017/9/25.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4,5,6));
    }

    public static String sum(int x,
                             int y,
                             int z,
                             int a,
                             int b,
                             int c){
        StringBuilder sb = new StringBuilder();
        return sb.append(x).append(y).append(z).append(a).append(b).append(c).toString();
    }

    /**
     * @param x
     * @param y
     * @param z
     * @param a
     * @param b
     * @return
     */
    private static String sum(int x,
                              int y,
                              int z,
                              int a,
                              int b,
                              String e){
        StringBuilder sb = new  StringBuilder();
        return sb.append(b).append(a).append(z).append(y).append(x).toString();
    }
}
