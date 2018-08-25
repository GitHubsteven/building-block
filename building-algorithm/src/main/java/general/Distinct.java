package general;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/23
 * @Time: 10:17
 * @Description:
 * @version: 1.0.0
 */
public class Distinct {
    public static void main(String[] args) {
        int deleteNumber = 2;
        int[] numbers = {1, 2,2, 3, 3, 5, 6, 7,8,8};
//        split(numbers, 2, 2);
        distinct(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    /**
     * 截取数组
     *
     * @param numbers 数组
     * @param start   开始，包括，从0开始
     * @param count   数量
     */
    public static void split(int[] numbers, int start, int count) {
        for (int i = start + count; i < numbers.length; i++) {
            numbers[i - count] = numbers[i];
            numbers[i] = 0;
        }
    }


    /**
     * 去重，不能增加集合对象，如array， collection等
     *
     * @param sortedArr 已经排好序了的数组
     */
    public static void distinct(int[] sortedArr) {
        int cur = 0;                  //当前的索引，如果与后面的数值不相等，那么就加一，
        int repeatNumber = 0;      //重复的数量，不包括第一个

        for (int i = cur; i < sortedArr.length - 1 && sortedArr[i] != 0; i++) {
            if (sortedArr[i] == sortedArr[i + 1]) {
                int temp = sortedArr[i];
                for (int j = i + 1; j < sortedArr.length; j++) {
                    if (sortedArr[j] != temp) {
                        break;     //遇到第一个和temp不相等的值，直接退出这个循环
                    }
                    repeatNumber++;
                }
                //如果repeatNumber不为0的话，那么需要去重
                split(sortedArr, i + 1, repeatNumber);
                repeatNumber = 0;//repeatNumber 复原为0
            }
        }

    }
}
