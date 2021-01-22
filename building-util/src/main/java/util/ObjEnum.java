package util;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/

import java.util.Objects;

/**
 * 枚举定义
 *
 * @author Wangtd 2020-06-04
 */
public interface ObjEnum<E> {

    E value();

    static <T extends ObjEnum<E>, E> T forEnum(T[] values, E e) {
        for (T value : values) {
            if (Objects.equals(value.value(), e)) {
                return value;
            }
        }
        return null;
    }

}