package com.demo.asa.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    private static AMap.TreeNode getTreeNode() {
        AMap.TreeNode treeNode = new AMap.TreeNode();
        treeNode.key = 12;
        treeNode.value = 21;
        return treeNode;
    }

    private static void operateCharacters() {
        System.out.println(24 >>> 2);   //6
        System.out.println(-24 >>> 2);  //? 无操作符就会忽略操作符
        System.out.println(24 >> 2);    //6
        System.out.println(-24 >> 2);   //-6
        int x = 10;
        System.out.println(x >> 2);
        // 位运算竟然不会改变变量的值
        System.out.println(x);
        // x++;
        System.out.println(++x);
        System.out.println(--x);
        System.out.println(--x);
        System.out.println(x);
    }

    static final int hash(Object key) {
        int h;
        if ((key == null)) {
            return 0;
        } else {
            int i = h = key.hashCode();
            return i ^ (h >>> 16);
        }
    }


    private static void mapTest() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        int[] numbers = {9, 8, 7, 12, 6, 5, 1, 11};
        Arrays.sort(numbers);
        int idx = Arrays.binarySearch(numbers, 12);
        System.out.println(idx);

        System.out.println(map.hashCode());

        Map<Integer, Integer> map2 = new HashMap<>();
        System.out.println(map2.hashCode());

        System.out.println("hash map");

        System.out.println(map.hashCode() == map2.hashCode());
    }
}
