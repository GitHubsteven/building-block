package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: https://leetcode.com/problems/range-sum-of-bst/
 * @Author asa.x
 * @Date: Created at 18:40 2020/1/20.
 */
public class LC938 {

    /**
     * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
     * <p>
     * The binary search tree is guaranteed to have unique values.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
     * Output: 32
     * Example 2:
     * <p>
     * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
     * Output: 23
     * <p>
     * <p>
     * Note:
     * <p>
     * The number of nodes in the tree is at most 10000.
     * The final answer is guaranteed to be less than 2^31.
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        if (root.val < L)
            return rangeSumBST(root.right, L, R);
        if (root.val > R)
            return rangeSumBST(root.left, L, R);

        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }

    public static void main(String[] args) {

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

}