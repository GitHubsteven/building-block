package custom;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:24 2019/3/22.
 */
public interface Parent<T extends Comparable<T>> {
    void apply(T param1);
}