package algorithm.link;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: asaland
 * @date: 2019/3/23
 * @time: 14:52
 * @version: 1.0.0
 * @description: 链表的节点
 **/
@Setter
@Getter
public class LinkNode<T extends Comparable<T>> {
    private T value;
    private LinkNode<T> pre;
    private LinkNode<T> next;

    public LinkNode(T value) {
        this.value = value;
    }

    public LinkNode() {
    }
}
