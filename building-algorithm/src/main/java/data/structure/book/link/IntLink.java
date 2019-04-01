package data.structure.book.link;

import algorithm.AdjLinkNode;
import algorithm.link.LinkNode;
import data.structure.book.link.Link;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 12:28 2019/4/1.
 */
public class IntLink extends Link<Integer> {

    public void reduceIfMoreAndDelIfEqual(LinkNode<Integer> head, Integer delIdx) {
        if (head == null) return;
        if (head.getValue() == null && head.getNext() != null) head = head.getNext();
        //保存头结点
        LinkNode<Integer> tmp = head;
        LinkNode<Integer> pre = head;
        do {
            int curVerIdx = tmp.getValue();
            if (curVerIdx == delIdx) {
                //判断是否为头结点，如果是的话，那么同时会改变头结点
                if (head.getValue().equals(delIdx)) {
                    head = tmp.getNext();
                    pre = tmp.getNext();
                } else {
                    pre.setNext(tmp.getNext());
                }
            } else if (curVerIdx > delIdx) {
                //如果顶点索引大于被删顶点索引的话，那么就-1
                tmp.setValue(curVerIdx - 1);
            } else {
                //如果是小于的话，那么不做处理
                pre = tmp;
            }
            tmp = tmp.getNext();
        } while (tmp.getNext() != null);
    }


    public static void main(String[] args) {
        IntLink link = new IntLink();
        LinkNode<Integer> node_1 = new LinkNode<>(1);
        link.addNode(node_1);
        link.addNode(new LinkNode<>(2));
        LinkNode<Integer> five = new LinkNode<>(5);
        link.addNode(five);
        link.addNode(new LinkNode<>(7));
        link.addNode(new LinkNode<>(3));
        link.traversal(link.getHead());
        System.out.println("\n--------------------reduce 5 ");
//        link.deleteNode(node_1);
        link.reduceIfMoreAndDelIfEqual(link.getHead(), 5);
        link.traversal(link.getHead());
    }
}