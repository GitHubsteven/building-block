package data.structure.book.tree.store;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 双亲链表表示法，树：
 * A
 * B   C    D
 * E     F   G     H
 * <p>
 * E为B的左孩子，F为C的左孩子，G为C的右孩子，H为D的右孩子
 * <p>
 * 如何描述树之间的关系：
 * 1. 数据结构为： data area, parent area(point to parent)
 * 2. 所有的数据都保存在一个数组中
 * @Date: Created at 10:56 2019/3/11.
 */
public class ParentLink<T extends Comparable<T>> {
    private final List<NodeStru<T>> elements = new ArrayList<>();

    public boolean add(NodeStru<T> node) {
        return elements.add(node);
    }

    public boolean remove(NodeStru<T> node) {
        return elements.remove(node);
    }

    public NodeStru<T> parent(NodeStru<T> node) {
        Integer parentIdx = node.getParentIdx();
        if (parentIdx == null) throw new BinException("该节点父类域为空！");
        if (parentIdx > size() - 1) throw new IllegalArgumentException("索引超出数值数目");
        return elements.get(parentIdx);
    }

    public List<NodeStru<T>> children(NodeStru<T> node) {
        int idx = -1;
        T node_val = node.getVal();
        for (int i = 0; i < elements.size(); i++) {
            if ((elements.get(i).getVal().compareTo(node_val) == 0)) {
                idx = i + 1;
                break;
            }
        }
        List<NodeStru<T>> children = new ArrayList<>(0);
        for (NodeStru<T> element : elements) {
            Integer parentIdx = element.getParentIdx();
            if (parentIdx != null && parentIdx == idx) {
                children.add(element);
            }
        }

        return children;
    }


    public int size() {
        return elements.size();
    }

    @Setter
    @Getter
    static class NodeStru<T> {
        private T val;
        //        private NodeStru<T> parent;
        //父类在数组中的结构中
        private Integer parentIdx;

        public NodeStru(T val, Integer parentIdx) {
            this.val = val;
            this.parentIdx = parentIdx;
        }
    }


    public static void main(String[] args) {
        ParentLink<String> tree = new ParentLink<>();
        tree.add(new NodeStru<>("A", 0));
        tree.add(new NodeStru<>("B", 1));
        NodeStru<String> node_c = new NodeStru<>("C", 1);
        tree.add(node_c);
        tree.add(new NodeStru<>("D", 1));
        tree.add(new NodeStru<>("E", 2));
        tree.add(new NodeStru<>("F", 3));
        tree.add(new NodeStru<>("G", 3));
        tree.add(new NodeStru<>("H", 4));

        for (NodeStru<String> sub : tree.children(node_c)) {
            System.out.print(sub.getVal() + "\t");
        }
    }
}