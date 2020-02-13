package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/22
 * @Time: 15:28
 * @Description: leetCode url:https://leetcode.com/problems/merge-two-binary-trees/
 * @version: 1.0.0
 */
// TODO: 2019/4/10  to complete
public class LC617 {
    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
     * <p>
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
     * Otherwise, the NOT null node will be used as the node of new tree.
     * <p>
     * Example 1:
     * Input:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * Output:
     * Merged tree:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     * Note: The merging process must start from the root nodes of both trees.
     */

//  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //merge current node
        if (t1 == null && t2 != null) return t2;
        if (t1 != null && t2 == null) return t1;
        if (t1 == null) return null;

        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        root.left = three;
        root.right = two;
        three.left = five;
        LC617 treeTest = new LC617();
    }
}