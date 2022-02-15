package leetcode.array;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/15
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _136_single_number {
    public static void main(String[] args) {
    }

    public static  int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
