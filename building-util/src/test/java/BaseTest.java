import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:32 2019/3/19.
 */
public class BaseTest {
    public static void main(String[] args) {
        System.out.println(String.format("%09d",123L));
    }

    private static void compareObj() {
        List<AClass> alist = new ArrayList<>();
        alist.add(new AClass("1", 1));
        alist.add(new AClass("2", 2));
        AClass c = new AClass("3", 3);
        alist.add(c);

        AClass csub = alist.stream().filter(it -> it.getName().equals("3"))
                .findFirst()
                .orElse(alist.get(0));

        for (AClass aClass : alist) {
            System.out.println(Objects.equals(aClass, csub));
        }
    }


    @Setter
    @Getter
    @AllArgsConstructor
    static class AClass {
        private String name;
        private Integer age;
    }
}