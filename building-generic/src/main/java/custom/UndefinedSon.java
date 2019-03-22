package custom;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 在继承父类的时候必须上传类型，否则父类无法知道子类定义的对象
 * @Date: Created at 16:26 2019/3/22.
 */
public class UndefinedSon<T extends Comparable<T>> implements Parent<T> {
    @Override
    public void apply(T param1) {

    }
}