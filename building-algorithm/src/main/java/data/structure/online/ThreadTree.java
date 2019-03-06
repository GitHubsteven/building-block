package data.structure.online;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 线索树，参考网址：https://blog.csdn.net/jiangnan2014/article/details/38656803
 * @Date: Created at 19:15 2019/3/6.
 */
@Getter
@Setter
public class ThreadTree {
    private TrdNode root;  //根节点
    private int size;
    private TrdNode pre;  //线索化的时候保存前驱

    public ThreadTree() {
        this.root = null;
        this.size = 0;
        this.pre = null;
    }

    public ThreadTree(int[] data) {
        this.size = data.length;
        this.root = createTree(data, 1);
    }

    public TrdNode createTree(int[] data, int index) {
        if (index > data.length) return null;
        TrdNode node = new TrdNode(data[index - 1]);
        TrdNode left = createTree(data, 2 * index);
        TrdNode right = createTree(data, 2 * index + 1);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    /**
     * 中序线索化树
     *
     * @param root 树的根节点
     */
    public void inThread(TrdNode root) {
        if (root == null) return;
        inThread(root.getLeft());
        if (root.getLeft() == null) {
            //设置前驱节点
            root.setLeftIsThread(true);
            root.setLeft(pre);
        }
        //给前驱节点设置后续节点
        if (pre != null && pre.getRight() == null) {
            pre.setRightIsThread(true);
            pre.setRight(root);
        }
        //重新赋值pre节点
        pre = root;
        //线索化右节点
        inThread(root.getRight());
    }

    /**
     * 中序遍历线索化后的数
     *
     * @param root 根节点
     */
    public void inThreadOrder(TrdNode root) {
        //如果为空，那么返回
        if (root == null) return;
        //找到树的起始节点
        TrdNode start = root;
        //找到第一个节点
        while (start != null && !start.isLeftIsThread()) {
            start = start.getLeft();
        }
        //找到这棵树的起点位置，因为我们建立线索链的时候没设置head
        do {
            System.out.print(start.getData() + ",");
            if (start.isRightIsThread()) {
                start = start.getRight();
            } else {
                //因为右孩子不是线索，所以我们需要找到右子树的开始位置
                start = start.getRight();
                while (start != null && !start.isLeftIsThread()) {
                    start = start.getLeft();
                }
            }
        } while (start != null);

    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    public void preOrder(TrdNode root) {
        if (root == null) return;
        System.out.print(root.getData() + ",");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(TrdNode root) {
        if (root == null) return;
        inOrder(root.getLeft());
        System.out.print(root.getData() + ",");
        inOrder(root.getRight());
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ThreadTree tree = new ThreadTree(data);  //生成树
        tree.inOrder(tree.getRoot());   //中序遍历
        System.out.println();

        tree.inThread(tree.getRoot());   //中序线索化
        tree.inThreadOrder(tree.getRoot()); //中序遍历线索化树
    }
}