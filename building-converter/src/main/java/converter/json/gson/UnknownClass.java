package converter.json.gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:39 2019/3/4.
 */
public class UnknownClass {

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3D);
        numbers.add(3.3f);
        for (Number number : numbers) {
            System.out.println(number.getClass().getSimpleName());
        }
    }
}