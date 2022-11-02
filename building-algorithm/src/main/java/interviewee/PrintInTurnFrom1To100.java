package interviewee;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/11/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class PrintInTurnFrom1To100 {
    public static void main(String[] args) {
        PrintTask task_odd = new PrintTask("odd");
        PrintTask task_even = new PrintTask("even");
        task_odd.start();
        task_even.start();
    }
}
