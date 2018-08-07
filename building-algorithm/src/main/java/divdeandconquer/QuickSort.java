package divdeandconquer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/25
 * @Time: 18:22
 * @Description:
 * @version: 1.0.0
 */
public class QuickSort implements ISort {
    public static void main(String[] args) {
        int[] source = {5, 6, 1, 3, 9, 25};
//        divide(source);
        int[] left = {1, 3, 5};
        int[] right = {2, 4, 6};
        merge(left, right);
    }

    public static void divide(int[] source) {
        //如果数字小于2，那么就不用分了

        if (source.length <= 2) {
            System.out.println("============================");
            sortTwo(source);
            for (int i : source) {
                System.out.print(" " + i);
            }
            System.out.println();

            return;
        }
        int start = 0;
        int end = source.length;
        int mid = start + end / 2;
        int[] left = Arrays.copyOfRange(source, start, mid);
        int[] right = Arrays.copyOfRange(source, mid, end);
        divide(left);
        divide(right);
    }

    public static int[] sortTwo(int[] twoEle) {
        if (twoEle.length == 2) {
            int first = twoEle[0];
            if (first > twoEle[1]) {
                twoEle[0] = twoEle[1];
                twoEle[1] = first;
                return twoEle;
            }
        }
        return twoEle;
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int leftLength = leftArr.length;
        int rightLength = rightArr.length;
        int[] temp = new int[leftLength + rightLength];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        for (; leftIndex < leftLength - 1 && rightIndex < rightLength - 1; ) {
            int leftIndexVal = leftArr[leftIndex];
            int rightIndexVal = rightArr[rightIndex];
            //比较，然后设置
            if (leftIndexVal > rightIndexVal) {
                temp[index++] = rightIndexVal;
                rightIndex++;
            } else {
                temp[index++] = leftIndexVal;
                leftIndex++;
            }
        }
        //将剩余的数字放进temp中,一下两个for循环应该只会执行一个
        for (; leftIndex < leftLength; ) {
            temp[index++] = leftArr[leftIndex++];
        }
        for (; rightIndex < rightLength; ) {
            temp[index++] = rightArr[rightIndex++];
        }

        System.out.println("===================array after sorted:");
        for (int ele : temp) {
            System.out.print(" " + ele);
        }
        return temp;
    }

}