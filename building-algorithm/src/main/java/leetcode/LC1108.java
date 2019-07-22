package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 20:05 2019/7/18.
 */
public class LC1108 {

    @Test
    public void entrance() {
        List<String> addresses = Arrays.asList("1.1.1.1", "255.100.50.0");
        addresses.forEach(add -> {
            System.out.println(defangIPaddr2(add));
        });
    }

    public String defangIPaddr(String address) {
        int length = address.length();
        char[] output = new char[length + 2 * 3];
        int output_i = 0;
        for (int idx = 0; idx < length; idx++) {
            char ele = address.charAt(idx);
            if (ele != '.') {
                output[output_i++] = ele;
            } else {
                output[output_i++] = '[';
                output[output_i++] = '.';
                output[output_i++] = ']';
            }
        }
//        return String.copyValueOf(output);
        return String.valueOf(output);
    }

    public String defangIPaddr2(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ele = address.charAt(i);
            if (ele != '.') {
                sb.append(ele);
            } else {
                sb.append('[').append('.').append(']');
            }
        }
        return sb.toString();
    }
}