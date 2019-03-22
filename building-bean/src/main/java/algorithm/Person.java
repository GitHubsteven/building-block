package algorithm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: asaland
 * @date: 2019/2/23
 * @time: 14:05
 * @version: 1.0.0
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
public class Person implements Comparable<Person> {
    public String name;
    public Integer age;

    public Person() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return name.equals(person.getName()) || age.equals(person.getAge());
    }

    @Override
    public int hashCode() {
//        int result = 31;
//        result = name.hashCode() * result;
//        return result * age;
        return super.hashCode();
    }

    @Override
    public int compareTo(Person o) {
        return this.age.compareTo(o.age);
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("1", 1));
        people.add(new Person("2", 2));

        System.out.println(people.indexOf(new Person("1", 1)));
        System.out.println(people.contains(new Person("1", 1)));
    }
}
