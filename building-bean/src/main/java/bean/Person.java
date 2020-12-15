package bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 18:39 2018/11/22.
 */
@Setter
@Getter
@AllArgsConstructor
public class Person extends BaseModel {
    private String name;
    private Integer age;

    public Person() {
    }

    public static void main(String[] args) {
        Person person = new Person("name1", 1);
        changeVal2(person);
        System.out.println(person.getName());
    }


    private static void changeVal(Person person) {
//        Person person2 = new Person("person2", 2);
        person.setName("name3");
    }

    private static void changeVal2(final Person person) {
        Person person2 = new Person("person2", 2);
        person.setName("nam2");
    }
}