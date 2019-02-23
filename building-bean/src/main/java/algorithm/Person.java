package algorithm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: asaland
 * @date: 2019/2/23
 * @time: 14:05
 * @version: 1.0.0
 * @description:
 **/
@Setter
@Getter
public class Person implements Comparable<Person> {
    public String name;
    public Integer age;

    @Override
    public int compareTo(Person o) {
        return this.age.compareTo(o.age);
    }

}
