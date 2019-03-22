package custom;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 子类直接传递父类泛型类型是可以的
 * @Date: Created at 16:25 2019/3/22.
 */
public class StringSon implements Parent<String> {
    @Override
    public void apply(String param1) {

    }
}