package data.structure.online;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 19:09 2019/3/6.
 */
@Setter
@Getter
public class TrdNode {
    private int data;
    private TrdNode left;
    private boolean leftIsThread = false;   //左孩子是否为线索
    private TrdNode right;
    private boolean rightIsThread = false;   //右孩子是否为线索

    public TrdNode(int data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TrdNode) {
            TrdNode tmp = (TrdNode) obj;
            if (tmp.getData() == this.data) {
                return true;
            }
        }
        return false;
    }
}