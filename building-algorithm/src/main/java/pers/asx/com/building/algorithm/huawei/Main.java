/**
 * @author: asx
 * @date: 2023/7/7
 * @descrition:
 */
package pers.asx.com.building.algorithm.huawei;

/**
 * @author: asx
 * @date: 2023/7/7
 * @descrition:
 */
public class Main {

    public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        // 获取每个根节点左|右子树最大深度，取他们之和
        return 0;
    }

    public static int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = depth;
        if(root.left != null){
            leftDepth = getDepth(root.left, depth);
        }
        int rightDepth = depth;

        if(root.right != null){
            rightDepth = getDepth(root.right, depth);
        }
        return Math.max(leftDepth, rightDepth);

    }
}
