package data.structure.online.thread;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 20:26 2019/3/6.
 */
public class ThreadTreeTest {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ThreadTree threadTree = new ThreadTree(data);      // 创建普通二叉树
        threadTree.inList(threadTree.getRoot());           // 中序递归遍历二叉树
        System.out.println();

        threadTree.inThread(threadTree.getRoot());         // 采用中序遍历将二叉树线索化
        threadTree.inThreadList(threadTree.getRoot());     // 中序遍历线索化二叉树
    }
}