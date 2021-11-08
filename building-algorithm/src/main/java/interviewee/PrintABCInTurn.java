package interviewee;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/11/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class PrintABCInTurn {
    public static void main(String[] args) {
        PrintABCTask task_A = new PrintABCTask("T-1", "A");
        PrintABCTask task_B = new PrintABCTask("T-2", "B");
        PrintABCTask task_C = new PrintABCTask("T-3", "C");


        task_A.start();
        task_C.start();
        task_B.start();
    }
}
