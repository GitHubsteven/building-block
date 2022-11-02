package leetcode.daily;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/25
 * @description https://leetcode-cn.com/problems/complex-number-multiplication/
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _537_complexNumberMultiply {
    public static void main(String[] args) {

        System.out.println(complexNumberMultiply("78+-76i", "-86+72i"));
    }

    public static String complexNumberMultiply(String num1, String num2) {
        int num1Splitor = num1.indexOf("+");
        int num2Splitor = num2.indexOf("+");
        // number 1
        int[] nums1Part = new int[2];
        nums1Part[0] = Integer.parseInt(num1.substring(0, num1Splitor));
        nums1Part[1] = Integer.parseInt(num1.substring(num1Splitor + 1, num1.length() - 1));
        // number2
        int[] nums2Part = new int[2];
        nums2Part[0] = Integer.parseInt(num2.substring(0, num2Splitor));
        nums2Part[1] = Integer.parseInt(num2.substring(num2Splitor + 1, num2.length() - 1));
        int real = nums1Part[0] * nums2Part[0] + nums1Part[1] * nums2Part[1] * (-1);
        int virtual = nums1Part[0] * nums2Part[1] + nums1Part[1] * nums2Part[0];

        return "" + real + "+" + virtual + "i";
    }
}
