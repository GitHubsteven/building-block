package com.function.program.performance;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 14:27 2018/5/14.
 */
public class CompareSwitchAndIfInFlow {

    public static void main(String[] args) {
        final int Loop = 100000;
        System.out.println("if case==============");
        long runTimeIf = LogUtil.logTime(Loop, CompareSwitchAndIfInFlow::caseIfInFlow, "2");
        System.out.println("switch case ===============");
        long runTimeCase = LogUtil.logTime(Loop, CompareSwitchAndIfInFlow::caseSwitchInFlow, "2");
        System.out.println("runTimeCase - runTimeIf: " + (runTimeCase - runTimeIf));
        System.out.println("switch/if: " + (runTimeCase / runTimeIf));
    }

    public static void caseIfInFlow(String aaa) {

        if ("1".equals(aaa)) {
            System.out.println(aaa);
        } else if ("2".equals(aaa)) {
            System.out.println(aaa);
        } else if ("3".equals(aaa)) {
            System.out.println(aaa);
        } else if ("4".equals(aaa)) {
            System.out.println(aaa);
        } else if ("5".equals(aaa)) {
            System.out.println(aaa);
        } else if ("6".equals(aaa)) {
            System.out.println(aaa);
        } else if ("7".equals(aaa)) {
            System.out.println(aaa);
        } else if ("8".equals(aaa)) {
            System.out.println(aaa);
        } else if ("9".equals(aaa)) {
            System.out.println(aaa);
        } else if ("10".equals(aaa)) {
            System.out.println(aaa);
        } else if ("11".equals(aaa)) {
            System.out.println(aaa);
        } else if ("12".equals(aaa)) {
            System.out.println(aaa);
        } else if ("13".equals(aaa)) {
            System.out.println(aaa);
        } else if ("14".equals(aaa)) {
            System.out.println(aaa);
        } else {
            System.out.println(aaa);
        }
    }

    public static void caseSwitchInFlow(String aaa) {
        switch (aaa) {
            case "1":
                System.out.println(aaa);
                break;
            case "2":
                System.out.println(aaa);
                break;
            case "3":
                System.out.println(aaa);
                break;
            case "4":
                System.out.println(aaa);
                break;
            case "5":
                System.out.println(aaa);
                break;
            case "6":
                System.out.println(aaa);
                break;
            case "7":
                System.out.println(aaa);
                break;
            case "8":
                System.out.println(aaa);
                break;
            case "9":
                System.out.println(aaa);
                break;
            case "10":
                System.out.println(aaa);
                break;
            case "11":
                System.out.println(aaa);
                break;
            case "12":
                System.out.println(aaa);
                break;
            case "13":
                System.out.println(aaa);
                break;
            case "14":
                System.out.println(aaa);
                break;
            default:
                System.out.println(aaa);
                break;
        }
    }
}
