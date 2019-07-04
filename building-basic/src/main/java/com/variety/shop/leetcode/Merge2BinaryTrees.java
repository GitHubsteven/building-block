package com.variety.shop.leetcode;

/**
 * Created by rongbin.xie on 2017/9/19.
 */

import java.nio.file.Path;
import java.util.regex.Pattern;

/**
 * 我竟然完全不会数了，我累个去
 * <p>
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Merge2BinaryTrees {
    private static final Pattern pattern = Pattern.compile("xx");



    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        TreeNode newTree = mergeTrees(t1, t2);
//        TraversalBinTree(newTree);
        TraversalBinTree(t1);
        System.out.println("------------------");
        TraversalBinTree(t2);
    }


    /**
     * fixme @asa.xie @2017年9月26日
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 || null == t2) {
            return t1 == null ? t2 : t1;
        }
        TreeNode newTree = new TreeNode(t1.val + t2.val);
        newTree.left = mergeTrees(t1.left, t2.left);
        newTree.right = mergeTrees(t1.right, t1.right);
        return newTree;
    }

    /**
     *
     * 前序遍历？
     *
     * @param treeNode 树
     */
    public static void TraversalBinTree(TreeNode treeNode) {
        if (null != treeNode) {
            System.out.println(treeNode.val);
        }
        if (null != treeNode && null != treeNode.left) {
            TraversalBinTree(treeNode.left);
        }
        if (null != treeNode && null != treeNode.right) {
            TraversalBinTree(treeNode.right);
        }
    }

    public static void midTraversalBinTree(TreeNode treeNode){

    }

}

class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}