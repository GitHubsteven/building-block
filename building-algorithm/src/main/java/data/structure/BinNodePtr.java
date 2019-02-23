package data.structure;

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
public class BinNodePtr implements BinNode {
    private Object element;
    private BinNodePtr left;
    private BinNodePtr right;

    public BinNodePtr() {
    }

    public BinNodePtr(Object element, BinNodePtr left, BinNodePtr right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}