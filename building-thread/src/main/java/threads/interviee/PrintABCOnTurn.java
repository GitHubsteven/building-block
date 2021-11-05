package threads.interviee;

/**
 * @Authoer: asa.x
 * @Date: 2021/11/5
 * @Descrition:
 */
public class PrintABCOnTurn {
    public static void main(String[] args) {
        PrintABCTask task_A = new PrintABCTask("T-1", "A");
        PrintABCTask task_B = new PrintABCTask("T-2", "B");
        PrintABCTask task_C = new PrintABCTask("T-3", "C");

        task_C.start();
        task_B.start();
        task_A.start();
    }
}
