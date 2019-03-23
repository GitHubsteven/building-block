package algorithm;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:10 2019/3/22.
 */
@Setter
@Getter
public class AdjVertex<T extends Comparable<T>> {
    /**
     * 邻接表的顶点
     */
    private T value;
    /**
     * 第一条边
     */
    private AdjLinkNode<T> firstEdge;
}