/**
 * @author: asx
 * @date: 2023/6/21
 * @descrition:
 */
package com.huaweiod;

import java.util.Scanner;

/**
 * @author: asx
 * @date: 2023/6/21
 * @descrition:
 */
public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
