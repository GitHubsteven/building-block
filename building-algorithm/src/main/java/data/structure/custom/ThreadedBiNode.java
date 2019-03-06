package data.structure.custom;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:15 2019/2/25.
 */
@Setter
@Getter
public class ThreadedBiNode<T extends Comparable<T>> {
    /**
     * 值
     */
    private T element;
    /**
     * 左孩子
     */
    private ThreadedBiNode<T> left;
    /**
     * 右孩子
     */
    private ThreadedBiNode<T> right;
    /**
     * true 表示left_child 是前驱，false 表示是儿子
     */
    private boolean leftIsThread;
    /**
     * true 表示前驱，false表示是儿子
     */
    private boolean rightIsThread;

    public ThreadedBiNode(T val) {
        this.element = val;
        leftIsThread = false;
        rightIsThread = false;
    }

    public ThreadedBiNode() {
        leftIsThread = false;
        rightIsThread = false;
    }
}