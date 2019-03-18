package bean;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 图的节点
 * @Date: Created at 11:36 2019/3/18.
 */
@Setter
@Getter
public class GraphicArc<T extends Comparable<T>> {
    /**
     * 起始点
     */
    private GraphicVertex<T> from;
    /**
     * 目的点
     */
    private GraphicVertex<T> to;

    /**
     * 权值
     */
    private BigDecimal weight;

    public GraphicArc(GraphicVertex<T> from, GraphicVertex<T> to) {
        this.from = from;
        this.to = to;
    }

    public GraphicArc(GraphicVertex<T> from, GraphicVertex<T> to, BigDecimal weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}