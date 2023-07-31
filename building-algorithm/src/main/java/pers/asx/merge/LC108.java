/**
 * @author: asx
 * @date: 2023/6/30
 * @descrition:
 */
package pers.asx.merge;


/**
 * @author: asx
 * @date: 2023/6/30
 * @descrition: https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */
public class LC108 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        int index = length / 2;
        if (length % 2 == 1) {
            index = index + 1;
        }
        TreeNode root = new TreeNode(nums[index-1]);
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            insertValue(root, value);
        }
        return root;
    }

    public static void insertValue(TreeNode node, int value) {
        if (node.val == value) return;
        if (value < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(value);
            } else {
                insertValue(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(value);
            } else {
                insertValue(node.right, value);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
