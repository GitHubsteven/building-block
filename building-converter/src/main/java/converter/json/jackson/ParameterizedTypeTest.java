package converter.json.jackson;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/10
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ParameterizedTypeTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        List<String> myList = new StringList();

        System.out.println(((ParameterizedType)strings.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        System.out.println(((ParameterizedType)numbers.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        System.out.println(((ParameterizedType)myList.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
