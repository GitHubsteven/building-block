package brute.force;

import java.util.Arrays;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/7/18
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {89, 45, 68, 90, 29, 34, 17};
        bubbleSort(numbers);
    }

    public static void bubbleSort(int[] numbers) {
        System.out.println("numbers before sort: " + Arrays.toString(numbers));
        int tmp;
        for (int i = 0; i <= numbers.length - 2; i++) {
            for (int j = 0; j <= numbers.length - i - 2; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    tmp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        System.out.println("numbers before sort: " + Arrays.toString(numbers));
    }
}
