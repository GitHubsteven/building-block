package data.structure.book;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 树节点
 * @Date: Created at 16:21 2019/2/22.
 */
@Setter
@Getter
public class BiNodePtr<T extends Comparable<T>> implements BiNode<T> {
    private T element;
    private BiNodePtr left;
    private BiNodePtr right;

    public BiNodePtr() {
    }

    public BiNodePtr(T element, BiNodePtr left, BiNodePtr right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}