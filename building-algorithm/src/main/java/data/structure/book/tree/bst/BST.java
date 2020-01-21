package data.structure.book.tree.bst;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 14:49 2020/1/21.
 */
@Setter
@Getter
public class BST {

    private TreeNode root;
    private int length;

    /**
     * @param root  树根
     * @param value 插入的值
     */
    public void binarySearchTree(TreeNode root, int value) {
        //insert to the left sub tree if value is less than the root.value
        if (root.val > value) {
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                binarySearchTree(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                binarySearchTree(root.right, value);
            }
        }
    }

    public int[] sort() {
        int[] result = new int[this.length + 1];
        result[0] = 1;
        midOrder(this.root, (node) -> {
            int index = result[0];
            result[index] = node.val;
            result[0] = index + 1;
        });
        return Arrays.copyOfRange(result, 1, this.length + 1);
    }

    /**
     * 中序遍历
     *
     * @param root 当前根节点
     */
    public void midOrder(TreeNode root, Consumer<TreeNode> visit) {
        if (root == null) return;
        midOrder(root.left, visit);
        visit.accept(root);
        midOrder(root.right, visit);
    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 根据数组生成二叉线索树
     *
     * @param array 数组
     * @return 树root
     */
    private TreeNode creatBSTFromArray(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            binarySearchTree(root, array[i]);
        }
        return root;
    }

    public BST(int[] array) {
        this.length = array.length;
        this.root = creatBSTFromArray(array);
    }

    public static void main(String[] args) {
        int[] numbers = {10, 7, 14, 20, 1, 5, 8};
        int[] sorted = new BST(numbers).sort();
        for (int i : sorted) {
            System.out.println(i);
        }
    }

}