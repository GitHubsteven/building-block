package algorithm;

import bean.GraphicVertex;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:01 2019/3/22.
 */
@Setter
@Getter
public class AdjLinkNode<T extends Comparable<T>> {
    private int verIdx;
    private AdjLinkNode<T> next;
    /**
     * 权重，如果存在的话
     */
    private BigDecimal weight;
}