package converter.json;

import converter.json.jackson.JacksonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/16
 * @description:
 * @CopyRight: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class CopyValue {
    public static void main(String[] args) {
        Son son = new Son();
        son.setSchool("ccnu");
        son.setAge(12);
        son.setName("son");
        convert(son);
    }

    @Setter
    @Getter
    public static class Parent {
        private String name;
        private Integer age;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Son extends Parent {
        private String school;
    }

    @Setter
    @Getter
    public static class Person {
        private String name;
        private Integer age;
        private String school;
    }

    public static void convert(Parent parent) {
        System.out.println(JacksonUtils.bean2Json(parent));
        Person person = new Person();
        BeanUtils.copyProperties(parent, person);
        System.out.println(person.getSchool());
    }
}
