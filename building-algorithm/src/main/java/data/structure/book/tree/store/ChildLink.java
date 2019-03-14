package data.structure.book.tree.store;

import bean.LinkNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 孩子链表表示法
 * <p>
 * 链表记录所有的节点，节点中记录所有孩子的节点的索引，为什么感觉这样
 * 对于树的增删改查是非常不方便的
 * @Date: Created at 11:24 2019/3/12.
 */
public class ChildLink<T extends Comparable<T>> {
    private List<Node<T>> links = new ArrayList<>(0);
    private int size;
    private Node<T> head;

    public ChildLink(Node<T> head) {
        size = 1;
        this.head = head;
        links.add(head);
    }

    public boolean add(Node<T> node) {
        if (node == null) return false;
//        ensureIdx(node);
        links.add(node);
        size++;
        return true;
    }

    public void ensureIdx(Node<T> node) {
        List<Integer> childrenIdxs = node.getChildren();
        if (CollectionUtils.isEmpty(childrenIdxs)) return;
        for (Integer childIdx : childrenIdxs) {
            if (childIdx > size) {
                throw new BinException("不能超出边界:" + size);
            }
        }
    }

    public List<Node<T>> children(Node<T> node) {
        List<Integer> childIdxs = node.getChildren();
        if (childIdxs == null || childIdxs.isEmpty()) {
            return null;
        }
        List<Node<T>> elements = new ArrayList<>();
        for (Integer childIdx : childIdxs) {
            if (childIdx > size) throw new IllegalArgumentException("孩子索引超出边界!");
            elements.add(links.get(childIdx - 1));
        }
        return elements;
    }


    /**
     * 每一个节点都有孩子的节点
     *
     * @param <T> 类型
     */
    @Setter
    @Getter
    @AllArgsConstructor
    static class Node<T extends Comparable<T>> {
        private T value;
        private List<Integer> children;
    }

    public static void main(String[] args) {
        Node<String> head = new Node<>("A", Arrays.asList(2, 3, 4));
        ChildLink<String> childLink = new ChildLink<>(head);
        childLink.add(new Node<>("B", Arrays.asList(5)));
        childLink.add(new Node<>("C", Arrays.asList(6, 7)));
        childLink.add(new Node<>("D", Arrays.asList(8)));
        childLink.add(new Node<>("E", null));
        childLink.add(new Node<>("F", null));
        childLink.add(new Node<>("G", null));
        childLink.add(new Node<>("H", null));

        childLink.children(head).forEach(it -> {
            System.out.println(it.getValue());
        });
    }
}