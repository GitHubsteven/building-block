package com.function.program.performance;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 13:20 2018/5/14.
 */
public class CompareSwitchAndIf {

    final static Map<String, Consumer<String>> consumerMap = createBranchMap();


    public static void main(String[] args) {
        int loopTime = 1000000;
        System.out.println("if case (ms)==============");
        long runTimeIf = LogUtil.logTime(loopTime, CompareSwitchAndIf::caseIf, "c");
        System.out.println("switch case (ms)===============");
        long runTimeCase = LogUtil.logTime(loopTime, CompareSwitchAndIf::caseSwitch, "c");
        System.out.println("switch map (ms)===============");
        long runTimeMap = LogUtil.logTime(loopTime, CompareSwitchAndIf::getBranchFromMap, "c");

        System.out.println("switch-if(ms): " + (runTimeCase - runTimeIf));
        System.out.println("map - if: " + ((double) runTimeMap - (double) runTimeIf));
    }


    public static void caseIf(String supplier) {
        if (supplier.equals("a")) {
            supplier = "1";
        } else if (supplier.equals("b")) {
            supplier = "2";
        } else if ("c".equals(supplier)) {
            supplier = "3";
        } else {
            supplier = "4";
        }

    }

    public static void caseSwitch(String supplier) {
        switch (supplier) {
            case "a":
                supplier = "1";
                break;
            case "b":
                supplier = "2";
                break;
            case "c":
                supplier = "3";
                break;
            default:
                supplier = "4";
        }

    }

    public static Map<String, Consumer<String>> createBranchMap() {
        Map<String, Consumer<String>> consumerMap = new HashMap<>();
        consumerMap.put("a", it -> it = "1");
        consumerMap.put("b", it -> it = "2");
        consumerMap.put("c", it -> it = "3");
        consumerMap.put("d", it -> it = "4");
//        consumerMap.put("")
        return consumerMap;
    }


    public static void getBranchFromMap(String key) {
        consumerMap.get(key).accept(key);
    }


}
