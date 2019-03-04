package data.structure.custom;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 21:43 2019/2/25.
 */
public class ThreadBinaryTree {
    private Node preNode;

    static class Node {
        String data; //数据域
        Node left;
        Node right;
        boolean isLeftThread = false;
        boolean isRightThread = false;

        public Node(String data) {
            this.data = data;
        }
    }

    /**
     * 通过数据构造一个二叉树（完全二叉树）
     *
     * @param array 数组
     * @param index 索引
     * @return
     */
    static Node createBinaryTree(String[] array, int index) {
        Node node = null;
        if (index < array.length) {
            node = new Node(array[index]);
            node.left = createBinaryTree(array, 2 * index + 1);
            node.right = createBinaryTree(array, 2 * index + 2);
        }
        return node;
    }

    /**
     * 终须线索化二叉树
     *
     * @param node 节点
     */
    void inThreadOrder(Node node) {
        if (node == null) {
            return;
        }
        //处理左子树,找到最先处理的节点
        inThreadOrder(node.left);
        //处理节点，如果为空的话，那么将空指针只想前节点
        if (node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }

        //前一个节点的后继节点指向当前节点
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }
        preNode = node;
        inThreadOrder(node.right);
    }

    /**
     * 中序遍历线索二叉树，按照后继方式遍历（思路：找到最左子节点开始）
     *
     * @param node
     */
    void inThreadList(Node node) {
        //1、找中序遍历方式开始的节点
        while (node != null && !node.isLeftThread) {
            node = node.left;
        }

        while (node != null) {
            System.out.print(node.data + ", ");

            //如果右指针是线索
            if (node.isRightThread) {
                node = node.right;

            } else {    //如果右指针不是线索，找到右子树开始的节点
                node = node.right;
                while (node != null && !node.isLeftThread) {
                    node = node.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
        Node root = createBinaryTree(array, 0);
        ThreadBinaryTree tree = new ThreadBinaryTree();
        tree.inThreadOrder(root);
        System.out.println("中序按后继节点遍历线索二叉树结果：");
        tree.inThreadList(root);
    }
}