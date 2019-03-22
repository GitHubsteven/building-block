package algorithm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 邻接表的边的描述
 * @Date: Created at 17:15 2019/3/22.
 */
@Setter
@Getter
@AllArgsConstructor
public class AdjArc<T extends Comparable<T>> {
    private AdjVertex<T> from;
    private AdjVertex<T> to;
    private BigDecimal weight;
}