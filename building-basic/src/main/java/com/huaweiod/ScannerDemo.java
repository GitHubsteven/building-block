/**
 * @author: asx
 * @date: 2023/6/21
 * @descrition:
 */
package com.huaweiod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: asx
 * @date: 2023/6/21
 * @descrition:
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pattern = "\\d+/[N|Y]";
        String curStudent = in.next(pattern);
        System.out.println(curStudent);
        while (in.hasNext(pattern)) {
            curStudent = in.next(pattern);
            System.out.println(curStudent);
        }
    }
}
