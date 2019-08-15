package threads;

import bean.Person;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:57 2019/8/5.
 */
public class ThreadLocalTest {
    private static final ThreadLocal<Person> userLocal = ThreadLocal.withInitial(Person::new);

    public static void main(String[] args) {
        Person person = userLocal.get();
        person.setAge(1);
        userLocal.set(person);
    }
}