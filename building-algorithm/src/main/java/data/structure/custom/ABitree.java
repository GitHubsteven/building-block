package data.structure.custom;

import algorithm.ANode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: asaland
 * @date: 2019/2/23
 * @time: 13:40
 * @version: 1.0.0
 * @description: 树的初始化
 **/
@Setter
@Getter
public class ABitree<T extends Comparable<T>> {
    private int MAX_SIZE = 63;
    private int INCREMENT = 10;

    private ANode<T> root;

    public ABitree(ANode<T> root) {
        this.root = root;
    }

    public ABitree(T rootVal) {
        this.root = new ANode<>(rootVal);
    }

    public ABitree(T[] values) {
        fromArray(values);
    }

    /**
     * 增加节点
     *
     * @param nodeValue 节点的值
     * @return 是否成功
     */
    public boolean addNode(T nodeValue) {
        ANode<T> insertNode = new ANode<>(nodeValue);
        return addNode(insertNode);
    }

    /**
     * 增加节点
     *
     * @param insertNode 增加的节点
     * @return 是否成功
     */
    private boolean addNode(ANode<T> insertNode) {
        //设置假设位置为root
        ANode<T> tmpNode = this.root;
        //查找节点改在的位置
        while (tmpNode != null) {
            T tmpNodeValue = tmpNode.getValue();
            int compareResult = tmpNodeValue.compareTo(insertNode.getValue());
            //小的在左，大的在右
            if (compareResult > 0) {
                if (tmpNode.getLeftChild() == null) {
                    tmpNode.setLeftChild(insertNode);
                    break;
                } else {
                    tmpNode = tmpNode.getLeftChild();
                }
            } else {
                if (tmpNode.getRightChild() == null) {
                    tmpNode.setRightChild(insertNode);
                    break;
                } else {
                    tmpNode = tmpNode.getRightChild();
                }
            }
        }
        return true;
    }

    /**
     * 先序遍历
     */
    public void preOrder(ANode<T> root, Consumer<ANode<T>> visit) {
        if (root == null) return;
        visit.accept(root);
        preOrder(root.getLeftChild(), visit);
        preOrder(root.getRightChild(), visit);
    }

    /**
     * 中序遍历
     *
     * @param root  根
     * @param visit 节点访问
     */
    public void midOrder(ANode<T> root, Consumer<ANode<T>> visit) {
        if (root == null) return;
        midOrder(root.getLeftChild(), visit);
        visit.accept(root);
        midOrder(root.getRightChild(), visit);
    }


    /**
     * 后序遍历
     *
     * @param root  根
     * @param visit 节点访问
     */
    public void postOrder(ANode<T> root, Consumer<ANode<T>> visit) {
        if (root == null) return;
        postOrder(root.getLeftChild(), visit);
        postOrder(root.getRightChild(), visit);
        visit.accept(root);
    }


    public ANode<T> getRoot() {
        return root;
    }

    public ABitree setRoot(ANode<T> root) {
        this.root = root;
        return this;
    }

    /**
     * 层次遍历
     */
    public void layerTraserval() {
        List<ANode<T>> curLayerNodes = new ArrayList<>(0);
        curLayerNodes.add(this.root);
        int layer = 1;
        List<ANode<T>> tmpLayerNodes = new ArrayList<>(0);
        while (!CollectionUtils.isEmpty(curLayerNodes)) {
            System.out.println("----------layer:" + layer++);
            for (ANode<T> node : curLayerNodes) {
                System.out.println(node.toString());
                if (node.getLeftChild() != null) {
                    tmpLayerNodes.add(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    tmpLayerNodes.add(node.getRightChild());
                }
            }
            curLayerNodes.clear();
            curLayerNodes.addAll(tmpLayerNodes);
            tmpLayerNodes.clear();
        }
    }

    public void fromArray(T[] values) {
        if (values == null || values.length == 0) return;
        root = new ANode<>(values[0]);
        for (int i = 1; i < values.length; i++) {
            this.addNode(values[i]);
        }
    }


    public static void main(String[] args) {
        Integer[] values = {6, 9, 4, 2, 8, 10, 5, 0, 7};
//        bitree.layerTraserval();
        List<ANode<Integer>> nodes = new ArrayList<>();
        ABitree<Integer> bitree = new ABitree<>(values);
        bitree.preOrder(bitree.getRoot(), nodes::add);
        System.out.println("preOrder:----------------------");
        for (ANode<Integer> node : nodes) {
            System.out.print(String.format("%s ", node.getValue()));
        }
        //中序遍历
        nodes.clear();
        bitree.midOrder(bitree.getRoot(), nodes::add);
        System.out.println("\nmidOrder:----------------------");
        for (ANode<Integer> node : nodes) {
            System.out.print(String.format("%s ", node.getValue()));
        }
        //后序遍历
        nodes.clear();
        bitree.postOrder(bitree.getRoot(), nodes::add);
        System.out.println("\npostOrder:----------------------");
        for (ANode<Integer> node : nodes) {
            System.out.print(String.format("%s ", node.getValue()));
        }
        System.out.println();
        nodes.clear();
        bitree.layerTraserval();
    }

}
