/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition:
 */
package pers.asx.dataandstructure;

/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition: 假设所有的数字是不同的
 */
public class TwoSumByTree {
    TreeNode root;
    int size;

    public void add(int number) {
        if (root == null) {
            root = new TreeNode(number);
        } else {
            add(root, number);
        }
        size++;
    }

    protected void add(TreeNode parent, int number) {
        if (number == parent.val) {
            parent.count++;
        } else if (parent.val < number) {
            // number > parent.val的话，在右子树
            if (parent.right == null) {
                parent.right = new TreeNode(number);
            } else {
                add(parent.right, number);
            }
        } else {
            // number < parent.val的话，在左子树
            if (parent.left == null) {
                parent.left = new TreeNode(number);
            } else {
                add(parent.left, number);
            }
        }
    }


    protected int findNumber(TreeNode parent, int number) {
        if (parent.val == number)
            return parent.count;
        // 如果是大于的话，那么在右子树中查找
        if (parent.val < number && parent.right != null) {
            return findNumber(parent.right, number);
        }
        if (parent.val > number && parent.left != null) {
            return findNumber(parent.left, number);
        }
        // 如果上述都不成立，那么返回0
        return 0;
    }


    public boolean find(int value) {
        if (size <= 1)
            return false;
        return find(root, value);
    }

    protected boolean find(TreeNode parent, int value) {
        if (parent == null)
            return false;
        // 如果存在的话，在整个书中查找是否存在目标的值
        int matchedCount = findNumber(root, value - parent.val);
        if (matchedCount > 0) {
            if ((value != 2 * parent.val)
                    || (value == 2 * parent.val && matchedCount > 1)) {
                return true;
            }
        }
        // 左节点查找
        if (find(parent.left, value)) {
            return true;
        }
        // 右节点查找
        return find(parent.right, value);
    }


    public static class TreeNode {

        public int val;

        public int count;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            count = 1;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.count = 1;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TwoSumByTree obj = new TwoSumByTree();
        obj.add(0);
        obj.add(-1);
        obj.add(-1);
        obj.add(0);
        System.out.println(obj.find(-2)); // true
    }
}
