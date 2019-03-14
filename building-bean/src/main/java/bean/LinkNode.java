package bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 链表的基本节点
 * @Date: Created at 11:34 2019/3/12.
 */
@Setter
@Getter
public class LinkNode<T extends Comparable<T>> {
    private T value;
    private LinkNode<T> pre;
    private LinkNode<T> next;
}