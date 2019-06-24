package com.function.program.chapter3;

/**
 * Created by rongbin.xie on 2018/1/17.
 */
public class MapUsingReduce {
    public static void main(String[] args) {
//        1534236469
        int x = -153;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);


//        System.out.println(revertNumber(x));
//        System.out.println(revert(x));
    }

    public static Integer revertNumber(Integer x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        boolean isNegative = false;
        String xStr = String.valueOf(x);
        String pureDig;
        if (xStr.startsWith("-")) {
            pureDig = xStr.substring(1);
            isNegative = true;
        } else {
            pureDig = xStr;
        }
        char[] pureNumbers = pureDig.toCharArray();
        int length = pureNumbers.length;
        if (length <= 0) return 0;
        Integer sum = 0;
        try {
            for (int i = 0; i < length; i++) {
                Double pow = Math.pow(10, i);
                sum = Math.addExact(sum, Math.multiplyExact(Character.getNumericValue(pureNumbers[i]), pow.intValue()));
            }
        } catch (Exception e) {
            return 0;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) return 0;
        return isNegative ? -1 * sum : sum;
    }

    /**
     * 使用位移思想来解决这个为题
     *
     * @param number number to be reverted
     * @return number reverted
     */
    public static int revert(int number) {
        long revert = 0;
        while (number != 0) {
            revert = revert * 10 + number % 10;
            number = number / 10;
            if(revert > Integer.MAX_VALUE || revert < Integer.MIN_VALUE)
                return 0;
        }
        return (int)revert;
    }


}
