package data.structure.book.link.conduct;

import algorithm.link.LinkNode;

public interface ILinkOperation<T extends Comparable<T>> {
    /**
     * 增加节点
     *
     * @param node 待增加的节点
     */
    boolean addNode(LinkNode<T> node);

    /**
     * 删除节点
     *
     * @param node 待删除的节点
     */
    boolean deleteNode(LinkNode<T> node);

    /**
     * 定位节点
     *
     * @param node 节点
     */
    int locateNode(LinkNode<T> node);

    /**
     * 遍历
     *
     * @param head 链表头结点
     */
    void traversal(LinkNode<T> head);
}
