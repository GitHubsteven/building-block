package converter.json.fastjson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:10 2019/4/3.
 */
public class TypeConverter {
    private final static ObjectMapper OM = new ObjectMapper();

    public static void main(String[] args) {
        User user = new User();
        user.setAge(1);
        user.setName("name1");
        user.setSalary(BigDecimal.ONE);
        Map<String, Object> resultMap = OM.convertValue(user, new TypeReference<Map<String, Object>>() {
        });
        resultMap.forEach((key, value) -> {
            System.out.println(String.format("key:%s,value:%s", key, value.toString()));
        });
    }
}