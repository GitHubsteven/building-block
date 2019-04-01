package converter.json.gson;

import com.google.gson.Gson;
import converter.json.fastjson.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:39 2019/3/4.
 */
public class UnknownClass {

    public static void main(String[] args) throws IllegalAccessException {
        Gson gson = new Gson();
        User user = new User();
        user.setName("name1");
        user.setAge(1L);
        System.out.println(gson.toJson(user));


        for (Field field : User.class.getDeclaredFields()) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(user, "hello");
            }
        }

        System.out.println(user.getName());
    }
}