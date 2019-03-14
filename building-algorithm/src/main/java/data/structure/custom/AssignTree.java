package data.structure.custom;

import bean.ThreadedBiNode;

import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 指定父类的树
 * @Date: Created at 12:21 2019/3/6.
 */
public class AssignTree<T extends Comparable<T>> {
    private ThreadedBiNode<T> root;

    public AssignTree(ThreadedBiNode<T> root) {
        this.root = root;
    }

    public AssignTree(T rootVal) {
        ThreadedBiNode<T> rt = new ThreadedBiNode<>(rootVal);
        this.root = rt;
    }

    public AssignTree() {

    }

    public enum Child {
        Left,
        Right
    }

    /**
     * 指定父类，并且指定位置，是左孩子还是有孩子
     * 1.如果根节点为空的话，那么抛出异常
     * 2.如果要插入的孩子节点不为空那么抛出异常
     *
     * @param root   数的根节点
     * @param val    插入的值
     * @param parent 父类
     * @param child  孩子的类型
     */
    public void add(ThreadedBiNode<T> root, T val, T parent, Child child) {
        if (root == null) return;
        if (root.getElement().compareTo(parent) == 0) {
            ThreadedBiNode<T> element = new ThreadedBiNode<>();
            element.setElement(val);
            if (Child.Left.equals(child)) {
                //插入左孩子
                ThreadedBiNode<T> leftChild = root.getLeft();
                if (leftChild != null)
                    throw new RuntimeException(String.format("目标父类[%s]的左孩子[%s]不为空，不能插入", parent, leftChild.getElement()));
                root.setLeft(element);
            } else {
                //插入右孩子
                ThreadedBiNode<T> rightChild = root.getRight();
                if (rightChild != null)
                    throw new RuntimeException(String.format("目标父类[%s]的右孩子[%s]不为空，不能插入", parent, rightChild.getElement()));
                root.setRight(element);
            }
            return;
        }
        //先序插入
        add(root.getLeft(), val, parent, child);
        add(root.getRight(), val, parent, child);
    }

    /**
     * 先序遍历线索化树
     *
     * @param root    当前根节点
     * @param preNode 前节点
     */
    public void preOrderThreaded(ThreadedBiNode<T> root, ThreadedBiNode<T> preNode) {
        if (root == null) return;
        if (root.getLeft() == null) {
            //如果左孩子为空的话，设为前驱
            root.setLeft(preNode);
            root.setLeftIsThread(true);
        }
        //给preNode 设置后驱节点
        if (preNode != null && preNode.getRight().isRightIsThread()) {
            preNode.setRight(root);
        }
        //如果右孩子为空呢？好像也做不了什么
        //把当前root设置为下一个的前节点
        preNode = root;
        preOrderThreaded(root.getLeft(), preNode);
        preOrderThreaded(root.getRight(), preNode);
    }

    /**
     * 中序遍历
     *
     * @param root    当前根节点
     * @param preNode 前节点
     */
    public void midOrderThreaded(ThreadedBiNode<T> root, ThreadedBiNode<T> preNode) {
        if (root == null) return;
        midOrderThreaded(root.getLeft(), preNode);
        if (root.getLeft() == null) {
            //如果左孩子为空的话，设为前驱
            root.setLeft(preNode);
            root.setLeftIsThread(true);
        }
        //给preNode 设置后驱节点
        if (preNode != null && preNode.getRight().isRightIsThread()) {
            preNode.setRight(root);
        }
        //如果右孩子为空呢？好像也做不了什么
        //把当前root设置为下一个的前节点
        preNode = root;
        midOrderThreaded(root.getRight(), preNode);
    }


    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    public void preOrderByThread(ThreadedBiNode<T> root) {

    }


    public static void main(String[] args) {
        AssignTree<Integer> assignTree = new AssignTree<>(3);
        assignTree.add(assignTree.root, 1, 3, Child.Left);
        assignTree.add(assignTree.root, 4, 3, Child.Left);
        assignTree.add(assignTree.root, 2, 4, Child.Left);
        assignTree.add(assignTree.root, 5, 4, Child.Right);

        Consumer<ThreadedBiNode<Integer>> consumer = (it) -> System.out.println(String.format("Node[%s]", it.getElement().toString()));
        System.out.println("先序遍历-----------");
        BiTreeOrderHelper.preOrder(assignTree.root, consumer);
        System.out.println("中序遍历-----------");
        BiTreeOrderHelper.midOrder(assignTree.root, consumer);
        System.out.println("后序遍历-----------");
        BiTreeOrderHelper.postOrder(assignTree.root, consumer);
        System.out.println("层次遍历-----------");
        BiTreeOrderHelper.layerTraverse(assignTree.root, consumer);

    }

}