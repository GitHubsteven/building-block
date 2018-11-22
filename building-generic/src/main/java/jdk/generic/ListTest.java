package jdk.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:17 2018/11/22.
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
//        tellGenericType(strings, numbers);
        requireInt(numbers);
//        requireObjCol(numbers);     // 不能通过编译，说明一个问题，编译会识别泛型类型
//        requireObjCol(strings);          // 不能通过编译，说明一个问题，编译会识别泛型类型
        requireObj(numbers);            //可以通过编译，作为obj来说
    }

    private static void tellGenericType(List<String> strings, List<Integer> numbers) {
        System.out.println(strings.getClass() == numbers.getClass());
        System.out.println("strings class:" + strings.getClass());
        System.out.println("numbers class:" + numbers.getClass());
    }

    public static void requireInt(Collection<Integer> params) {
    }

    public static void requireObjCol(Collection<Object> param) {

    }

    public static void requireObj(Object obj) {

    }
}