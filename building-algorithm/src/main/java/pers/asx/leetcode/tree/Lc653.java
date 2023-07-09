/**
 * @author: asx
 * @date: 2023/7/8
 * @descrition:
 */
package pers.asx.leetcode.tree;

/**
 * @author: asx
 * @date: 2023/7/8
 * @descrition:
 */
public class Lc653 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
    }


    public static boolean findTarget(TreeNode root, int k) {
        if(root.left == null && root.right == null) return false;
        //中序遍历树
         return  mid_tras(root, root, k);
    }

    public static boolean mid_tras(TreeNode root, TreeNode parent, int k) {
        if (parent == null)
            return false;
        // 如果当前节点满足
        int addedVal = findValue(root, k - parent.val);
        // 如果节点不重复并且存在
        if (addedVal != Integer.MIN_VALUE && addedVal != parent.val) {
            return true;
        } else {
            if (parent.left != null) {
                // 遍历左节点
                boolean isMatched = mid_tras(root, parent.left, k);
                if (isMatched)
                    return true;
            }
            if (parent.right != null) {
                return mid_tras(root, parent.right, k);
            }
            return false;
        }
    }


    public static int findValue(TreeNode root, int k) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.val == k) {
            return k;
        }
        if (k < root.val && root.left != null) {
            return findValue(root.left, k);
        } else if (k > root.val && root.right != null) {
            return findValue(root.right, k);
        }
        return Integer.MIN_VALUE;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
