package com.demo.asa.building.reflect.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: ？---通配符表达式，表示通配符泛型，但是WildcardType并不属于Java-Type中的一钟；
 * 例如：List<? extends Number> 和 List<? super Integer>；
 * <p></p>
 * @Author asa.x
 * @Date: Created at 14:43 2020/3/11.
 */
public class WildCardTypeTest {
    private List<? extends Number> listNum = null;
    private List<? super GetOrderResponse> listRes = null;

    public static void main(String[] args) throws NoSuchFieldException {
        getBounds("listNum");  //get upper bounds;
        getBounds("listRes");  //get lower bounds;
    }

    private static void getBounds(String fieldName) throws NoSuchFieldException {
        Field listNum = WildCardTypeTest.class.getDeclaredField(fieldName);
        ParameterizedType parameterizedType = (ParameterizedType) listNum.getGenericType();
        for (Type argGeneric : parameterizedType.getActualTypeArguments()) {
            WildcardType wildcardType = (WildcardType) argGeneric;
            System.out.println("----------> upper bounds");
            for (Type upperBound : wildcardType.getUpperBounds()) {
                System.out.println(upperBound.getTypeName());
            }

            System.out.println("----------> lower bounds");
            for (Type lowerBound : wildcardType.getLowerBounds()) {
                System.out.println(lowerBound.getTypeName());
            }
        }
    }
}