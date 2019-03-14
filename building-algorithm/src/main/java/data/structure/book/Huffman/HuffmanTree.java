package data.structure.book.Huffman;

import data.structure.custom.BiTreeOrderHelper;
import bean.ThreadedBiNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 根据给定的值来构造Huffman树
 * @Date: Created at 10:36 2019/3/14.
 */
public class HuffmanTree {
    /**
     * 构建二叉树，返回根节点
     *
     * @param values 给定的值，作为子树没有任何子节点
     */
    public static ThreadedBiNode<Integer> construct(List<ThreadedBiNode<Integer>> values) {
        //先排序,请输入size >2的集合
        values.sort(Comparator.comparing(ThreadedBiNode::getElement));
        ThreadedBiNode<Integer> least;
        ThreadedBiNode<Integer> secLeast;
        //设置一个指向哈夫曼二叉树根节点的指针
        ThreadedBiNode<Integer> root = null;
        //1.合并这两个节点，创建新的节点，2.从集合中删除least和secLeast 3.往values中增加新添加的节点
        while (values.size() > 1 && (least = values.get(0)) != null && (secLeast = values.get(1)) != null) {
            ThreadedBiNode<Integer> node = new ThreadedBiNode<>(least.getElement() + secLeast.getElement());
            node.setLeft(least);
            node.setRight(secLeast);
            //删除两个节点
            values.remove(least);
            values.remove(secLeast);
            //添加新节点
            values.add(node);
            root = node;
            //重新排序（这里可以优化，但是，现在暂时不管）,重新获取最小，第二个最小的节点
            values.sort(Comparator.comparing(ThreadedBiNode::getElement));
        }
        return root;
    }

    public static void main(String[] args) {
        ThreadedBiNode<Integer> five = new ThreadedBiNode<>(5);
        ThreadedBiNode<Integer> ten = new ThreadedBiNode<>(10);
        ThreadedBiNode<Integer> fifteen = new ThreadedBiNode<>(15);
        ThreadedBiNode<Integer> thirty = new ThreadedBiNode<>(30);
        ThreadedBiNode<Integer> forty = new ThreadedBiNode<>(40);

        List<ThreadedBiNode<Integer>> values = new ArrayList<>();
        values.add(five);
        values.add(ten);
        values.add(fifteen);
        values.add(thirty);
        values.add(forty);
        ThreadedBiNode<Integer> root = construct(values);
        //
//        BiTreeOrderHelper.layerTraverse(root, (ele) -> System.out.println(ele.custom2String()));

        BiTreeOrderHelper.preOrder(root, (ele) -> System.out.println(ele.custom2String()));
    }

}