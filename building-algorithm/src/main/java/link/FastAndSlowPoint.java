package link;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 快指针和慢指针, 对于快慢指针的原理，好像也没啥说的。
 * <p>
 * 设链表的长度为L,快指针的速度为f，慢指针的速度为s，那么对于单链表来说：
 * L/f = time_stop, 此时慢指针的行驶路程为time_stop *  s， 如果f/s = n的话有如下公式
 * <p>
 * L/f * s = L/n，当n为2的时候，那么我们可以找到链表的中间节点
 * example：
 * 设 n= 9, f =2, s =1,那么有 9/2 *1 = 4.5 ，4.5 ->5;
 * <p>
 * 对于回环链来说，可以看做是一个圆，时钟的情形是类似的，fast = 分针，slow = 时针，很明显 fast/slow = 60;
 * 那么再回环中，情形是如何的呢？设回环长度为L，那么有如下公式
 * <p>
 * 设 run_time为运行时间
 * <p>
 * run_time * fast % L = fast_cur_pos;
 * <p>
 * run_time * fast % L = slow_cur_pos;
 * <p>
 * 当 fast_cur_pos = slow_cur_pos时，那么fast和slow就会相遇。
 * @Date: Created at 9:45 2019/3/12.
 */
public class FastAndSlowPoint {
    private final Node head = new Node("head");
    private int SIZE = 10;

    {
        Node pre = head;
        for (int i = 1; i <= SIZE; i++) {
            Node node = new Node("node" + i);
            pre.setNext(node);
            node.setPreNode(pre);

            pre = node;
        }
    }

    public Node getMid(Node head) {

        Node fastPointer = head;
        Node slowPointer = head;
        while (fastPointer.getNext() != null) {
            Node grandNext = fastPointer.getNext().getNext();
            //如果第二个继承者
            if (grandNext == null) {
                fastPointer = fastPointer.getNext();
                slowPointer = slowPointer.getNext();
                break;
            } else {
                fastPointer = grandNext;
                slowPointer = slowPointer.getNext();
            }
        }
        System.out.println("last point val:" + fastPointer.getValue());
        return slowPointer;
    }

    public static void main(String[] args) {
        FastAndSlowPoint test = new FastAndSlowPoint();
        Node mid = test.getMid(test.head);
        System.out.println(mid.getValue());
    }


    @Setter
    @Getter
    static class Node {
        private String value;
        private Node preNode;
        private Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}