package com.demo.asa.building.reflect.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:39 2019/10/16.
 */
public class TypeTest {
    /**
     * 对应
     * class --->正常的类，不是容器和泛型
     * ParameterizedType --->容器，一般如list,map，set等
     * GenericArrayType ---> GenericArrayTyp 当需要描述的类型是泛型类的数组时，比如比如List[],Map[]，type会用GenericArrayType接口作为Type的实现。
     * wildCard ----->当需要描述的类型是泛型类，而且泛型类中的泛型被定义为(? extends xxx)或者(? super xxx)这种类型，
     * 比如List<? extends TestReflect>，这个类型首先将由ParameterizedType实现
     * TypeVariable ---> Type的最后一种实现形式是TypeVariable接口，这种实现形式是在泛型类中使用的。
     *
     * 比如我们定义一个泛型类TestReflect<T>，并在类中定义方法oneMethod(T para)，那么当调用method.getGenericParameterTypes()方法得到的Type数组，数组的元素就是由TypeVariable接口实现的。
     *
     * 真正的实现类是sun.reflect.generics.reflectiveObjects. TypeVariableImpl。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Type[] genericInterfaces = TypeModel.class.getGenericInterfaces();
        for (Type ele : genericInterfaces) {
            System.out.println(ele.getTypeName());
            if (ele instanceof ParameterizedType) {
                ParameterizedType iModel = (ParameterizedType) ele;
                Type[] arguments = iModel.getActualTypeArguments();
                for (Type argument : arguments) {
                    System.out.println(argument.getTypeName());
                }
            }
        }
    }

    public static void test(List<TypeModel> models,
                            Map<String, Integer> map) {
    }
}