package com.function.program.performance;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 18:06 2018/5/15.
 */
public class DefineAndLoop {
    public static void main(String[] args) {
        String loopTime = "90000000";
        long before = LogUtil.logTime(1, DefineAndLoop::declareBefore, loopTime);
        long in = LogUtil.logTime(1, DefineAndLoop::declareInLoop, loopTime);
        System.out.println("before - in(ms) : "+ (before - in));
    }


    public static void declareBefore(String time) {
        int loopTime = Integer.parseInt(time);
        for (int i = 0; i < loopTime; i++) {
            String code = "" + i;
            String sku = "" + i;
            String upc = "" + i;
            String size = "" + i;
            String productName = "" + i;
            String color = "" + i;


        }
    }

    public static void declareInLoop(String time) {
        String code = "";
        String sku = "";
        String upc = "";
        String size = "";
        String productName = "";
        String color = "";
        int loopTime = Integer.parseInt(time);

        for (int i = 0; i < loopTime; i++) {
            code = "" + i;
            sku = "" + i;
            upc = "" + i;
            size = "" + i;
            productName = "" + i;
            color = "" + i;
        }
    }
}
