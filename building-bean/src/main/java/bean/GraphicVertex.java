package bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 图的顶点
 * @Date: Created at 11:12 2019/3/18.
 */
@Setter
@Getter
@AllArgsConstructor
public class GraphicVertex<T extends Comparable<T>> {
    private T value;

}