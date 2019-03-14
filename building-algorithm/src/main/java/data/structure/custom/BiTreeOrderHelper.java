package data.structure.custom;

import bean.ThreadedBiNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:06 2019/3/6.
 */
public class BiTreeOrderHelper {
    /**
     * 先序遍历
     *
     * @param root 当前根节点
     */
    public static <T extends Comparable<T>> void preOrder(ThreadedBiNode<T> root, Consumer<ThreadedBiNode<T>> visit) {
        if (root == null) return;
        visit.accept(root);
        preOrder(root.getLeft(), visit);
        preOrder(root.getRight(), visit);
    }

    /**
     * 中序遍历
     *
     * @param root 当前根节点
     */
    public static <T extends Comparable<T>> void midOrder(ThreadedBiNode<T> root, Consumer<ThreadedBiNode<T>> visit) {
        if (root == null) return;
//        System.out.println(String.format("node:[%s]", root.getElement().toString()));
        midOrder(root.getLeft(), visit);
        visit.accept(root);
        midOrder(root.getRight(), visit);
    }

    /**
     * 后序遍历
     *
     * @param root 当前根节点
     */
    public static <T extends Comparable<T>> void postOrder(ThreadedBiNode<T> root, Consumer<ThreadedBiNode<T>> visit) {
        if (root == null) return;
        postOrder(root.getLeft(), visit);
        postOrder(root.getRight(), visit);
        visit.accept(root);
    }

    /**
     * 层次遍历
     */
    public static <T extends Comparable<T>> void layerTraverse(ThreadedBiNode<T> root, Consumer<ThreadedBiNode<T>> visit) {
        List<ThreadedBiNode<T>> curLayerNodes = new ArrayList<>(0);
        curLayerNodes.add(root);
        int layer = 1;
        List<ThreadedBiNode<T>> tmpLayerNodes = new ArrayList<>(0);
        while (!CollectionUtils.isEmpty(curLayerNodes)) {
            System.out.println("----------layer:" + layer++);
            for (ThreadedBiNode<T> node : curLayerNodes) {
                visit.accept(node);
                if (node.getLeft() != null) {
                    tmpLayerNodes.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    tmpLayerNodes.add(node.getRight());
                }
            }
            curLayerNodes.clear();
            curLayerNodes.addAll(tmpLayerNodes);
            tmpLayerNodes.clear();
        }
    }
}