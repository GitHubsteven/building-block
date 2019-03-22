package jdk.generic.basic.action;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:33 2019/3/21.
 */
@FunctionalInterface
public interface ThreeFunction<T, V, R> {
    R apply(T param1, V param2);
}