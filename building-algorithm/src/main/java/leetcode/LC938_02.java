package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 16:03 2020/1/21.
 */
public class LC938_02 {
    int result = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return result;
        }

        calculateRangeSum(root, L, R);
        return result;
    }

    public void calculateRangeSum(TreeNode root, int L, int R) {

        if (root == null) {
            return;
        }

        if (root.val >= L && root.val <= R) {
            result += root.val;
        }
        //** Check for the conditions only true continue with recursion ***//
        if (root.val > L) calculateRangeSum(root.left, L, R);
        if (root.val < R) calculateRangeSum(root.right, L, R);

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