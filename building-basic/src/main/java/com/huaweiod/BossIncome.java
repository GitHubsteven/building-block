/**
 * @author: asx
 * @date: 2023/6/21
 * @descrition:
 */
package com.huaweiod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: asx
 * @date: 2023/6/21
 * @descrition:
 */
public class BossIncome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int staffNumber = in.nextInt();
        // 员工信息
        String staff = "";
        int staffNo = -1;
        // 上级编号
        int staffLeaderNo = -1;
        // 收入
        int staffIncome = 0;
        // 员工收入，默认为0
        int[] incomes = new int[staffNumber];
        // 上级编码
        int[] leaderNo = new int[staffNumber];
        Arrays.fill(leaderNo, -1);
        // 读取五个员工的信息
        for (int i = 0; i < staffNumber; i++) {
            staff = in.nextLine();
            String[] parts = staff.split(" ");
            staffNo = Integer.valueOf(parts[0]);
            staffLeaderNo = Integer.valueOf(parts[1]);
            staffIncome = Integer.valueOf(parts[2]);
            // 计算当前读取的收入信息给当前员工和上级员工带来的收入影响
            leaderNo[staffNo] = staffLeaderNo;
            addIncome(staffIncome, staffNo, leaderNo, incomes);
        }

    }

    /**
     * 增加工资
     */
    public static void addIncome(int addIncome, int staffNo, int[] leaderNo, int[] incomes) {
        int preIncome = incomes[staffNo];
        int afterIncome = preIncome + addIncome;
        incomes[staffNo] = afterIncome;
        // 如果有上级，那么计算income收入差值给上级带来的利润影响
        int dif = (afterIncome % 100 - preIncome % 100) * 15;
        if (dif > 0 && leaderNo[staffNo] > -1) {
            addIncome(addIncome, leaderNo[staffNo], leaderNo, incomes);
        }
    }
}
