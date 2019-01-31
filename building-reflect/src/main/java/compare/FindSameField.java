package compare;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:36 2019/1/31.
 */
public class FindSameField {
    public static <T, R> void findSameFields(Class<T> first, Class<R> later) {
        Set<String> firstFieldNanme = Stream.of(first.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toSet());
        int i = 0;
        for (Field reqField : later.getDeclaredFields()) {
            String name = reqField.getName();
            if (firstFieldNanme.contains(name)) {
                System.out.println(name);
                i++;
            }
        }
        System.out.println(i);
    }
}