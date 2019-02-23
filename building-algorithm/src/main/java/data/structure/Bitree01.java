package data.structure;

import java.io.Console;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:25 2019/2/22.
 */
public class Bitree01 {
    public static void main(String[] args) {
        int index = 1; //数组下标变量
        int data; //读取输入的临时变量
        BiTreeArray biTree = new BiTreeArray();
        System.out.println("请输入二叉树数据元素，输入0退出！");

        ConsoleReader console = new ConsoleReader(System.in);
        do {
            System.out.println("data" + index + ":");
            data = console.readInt();
            biTree.create(data);
            index++;
        } while (data != 0);
        biTree.printAll();
    }

    static class BiTreeArray {
        int MAX_SIZE = 63;
        int[] abiTree = new int[MAX_SIZE];

        public void create(int data) {
            int i;
            int level;  //树的层数

            level = 1; //从层1开始建立
            while (abiTree[level] != 0) {
                if (data < abiTree[level])
                    level = level * 2;
                else
                    level = level * 2 + 1;
            }
            abiTree[level] = data;
        }

        public void printAll() {
            System.out.println("二叉树的节点值依次为：");
            for (int i = 0; i < abiTree.length; i++) {
                int value = abiTree[i];
                if (value != 0) {
                    System.out.println(String.format("Node:[%d] value = %2d", i, value));
                }
            }
        }
    }

}