package jdk.generic.box;

import java.util.Collection;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:31 2018/11/22.
 */
public class BoxTest {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();
        integerBox.setValue(1);
//        requireBox(integerBox);         //可以通过编译
//        requireBoxStr(integerBox);  // 不能通过编译，这说明了，泛型对于类型定义来说，如果你的泛型不定义，直接使用封装类，那么，是可以通过编译的（默认为Object）
// ，但是如果封装指定了泛型类型，那么编译器就会检测泛型的类型了，

        require(stringBox, integerBox);
    }

    public static void requireBox(Box param) {

    }

    public static void requireBoxStr(Box<String> strParam) {

    }

    private static void require(Box<String> stringBox, Box box) {
        System.out.println("Box<String> 和Box的类型是相同的：" + (stringBox.getClass() == box.getClass()));
    }

    public static void doubleGeneric(Box<Collection> param) {

    }
}