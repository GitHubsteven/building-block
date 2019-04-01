package data.structure.book.link;

import algorithm.link.LinkNode;
import data.structure.book.link.conduct.ILinkOperation;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: asaland
 * @date: 2019/3/23
 * @time: 14:16
 * @version: 1.0.0
 * @description: 链表操作
 **/
@Getter
@Setter
public class Link<T extends Comparable<T>> implements ILinkOperation<T> {
    private LinkNode<T> head;

    public Link() {
        head = new LinkNode<>();
    }

    @Override
    public boolean addNode(LinkNode<T> node) {
        LinkNode<T> tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(node);
        return true;
    }

    @Override
    public boolean deleteNode(LinkNode<T> node) {
        T value = node.getValue();
        LinkNode<T> tmp = head;
        LinkNode<T> pre;
        while (tmp.getNext() != null) {
            pre = tmp;
            tmp = tmp.getNext();
            if (tmp.getValue().compareTo(value) == 0) {
                pre.setNext(tmp.getNext());
                tmp.setNext(null);
            }
        }
        return false;
    }

    @Override
    public int locateNode(LinkNode<T> node) {
        int index = 0;
        LinkNode<T> tmp = this.head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            index++;
            if (tmp.getValue().compareTo(node.getValue()) == 0) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void traversal(LinkNode<T> head) {
        LinkNode<T> tmp = head;
        while (tmp.getNext() != null) {
            System.out.print(tmp.getNext().getValue() + "\t");
            tmp = tmp.getNext();
        }
    }



    public static void main(String[] args) {
        Link<Integer> link = new Link<>();
        LinkNode<Integer> node_1 = new LinkNode<>(1);
        link.addNode(node_1);
        link.addNode(new LinkNode<>(2));
        LinkNode<Integer> five = new LinkNode<>(5);
        link.addNode(five);
        link.addNode(new LinkNode<>(7));
        link.addNode(new LinkNode<>(3));
        link.traversal(link.getHead());
        System.out.println("\n--------------------delete node 1");
        link.deleteNode(node_1);
        link.traversal(link.getHead());
    }
}
