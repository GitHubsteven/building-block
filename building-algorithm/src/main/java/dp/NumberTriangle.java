package dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/7
 * @Time: 15:54
 * @Description:
 */
public class NumberTriangle {

    public static void main(String[] args) {
        int[][] steps = new int[4][];
        int[] step1 = {2};
        int[] step2 = {3, 4};
        int[] step3 = {5, 1, 7};
        int[] step4 = {6, 3, 2, 8};
        steps[0] = step1;
        steps[1] = step2;
        steps[2] = step3;
        steps[3] = step4;

        int min = recurse(steps, 4);
        System.out.println(min);
    }

    /**
     * Question description:
     * steps such as following:
     * 1: [2]
     * 2: [3,4]
     * 3: [5,1,7]
     * 4:[6,3,2,8]
     * <p>
     * from step1 to step 4, get one number each step, find the path that sum the number is smallest, in this case, answer is
     * 2 + 3+ 1+ 2 = 8
     */

    public static int recurse(int[][] steps, int currentStep) {
        int length = steps.length;
        int[] stepNumbers = steps[currentStep - 1];
        int min = Arrays.stream(stepNumbers).min().orElse(0);
        if (currentStep == 1) {
            return min;
        }
        int[][] subSteps = Arrays.copyOfRange(steps, 0, currentStep);
        return min + recurse(subSteps, currentStep - 1);
    }


}