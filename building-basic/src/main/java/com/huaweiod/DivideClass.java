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
 * @descrition: 分班
 */
public class DivideClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] students = line.split(" ");
        String curStudent = students[0];
        List<Integer> classA = new ArrayList<>();
        List<Integer> classB = new ArrayList<>();
        // 假设第一个同学在A班
        String[] parts = curStudent.split("/");
        Integer studentNum = Integer.valueOf(parts[0]);
        classA.add(studentNum);
        // 设当前班为A，另外一个班明为B
        List<Integer> curClass = classA;
        String isSameFlag;
        for (int i = 1; i < students.length; i++) {
            curStudent = students[i];
            parts = curStudent.split("/");
            // 读取并且重置学生No
            studentNum = Integer.valueOf(parts[0]);
            isSameFlag = parts[1];
            if ("Y".equalsIgnoreCase(isSameFlag)) {
                // 如果和前一个同学同一个班的话，那么就加入当前班，否则的话，就加入另外一个班
                curClass.add(studentNum);
            } else {
                // 如果不是同班的话，那么就加入另外一个班，同时更新班级名称
                curClass = curClass == classA ? classB : classA;
                curClass.add(studentNum);
            }
        }
        if (!classA.isEmpty()) {
            classA.sort(Integer::compare);
            for (Integer no : classA) {
                System.out.printf("%d ", no);
            }
        }
        System.out.println();
        if (!classB.isEmpty()) {
            classB.sort(Integer::compare);
            for (Integer no : classB) {
                System.out.printf("%d ", no);
            }
        }
    }

}
