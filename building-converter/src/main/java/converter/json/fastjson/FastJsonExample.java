package converter.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/25
 * @Time: 17:40
 * @Description:
 * @version: 1.0.0
 */
public class FastJsonExample {

    public static void main(String[] args) {
        FastJsonExample eg = new FastJsonExample();
//        eg.specifiedEffect();
        eg.customSerTest();
    }

    public void _2JsonTest() {
        User user = new User();
        user.setName("校长");
        user.setAge(3);
        user.setSalary(new BigDecimal("123456789.0123"));
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
        // 输出 {"age":3,"name":"校长","old":false,"salary":123456789.0123}
    }

    public void fromJsonTest() {
        String jsonString = "{\"age\":3,\"birthdate\":1496738822842,\"name\":\"校长\",\"old\":true,\"salary\":123456789.0123}";
        User user = JSON.parseObject(jsonString, User.class);
        System.out.println(user.getName());

        String jsonStringArray = "[{\"age\":3,\"birthdate\":1496738822842,\"name\":\"校长\",\"old\":true,\"salary\":123456789.0123}]";
        List<User> users = JSON.parseArray(jsonStringArray, User.class);
        System.out.println(users);
    }


    public void specifiedEffect() {
        Word word = new Word();
        word.setA("a");
        word.setB(2);
        word.setC(true);
        word.setD("d");
        word.setE("");
        word.setF(null);
        word.setDate(new Date());

        System.out.println(JSON.toJSONString(word));
        System.out.println(JSON.toJSONString(word, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty));
    }

    public void customSerTest() {
        CusModel model = new CusModel();
        model.value = 100;
        String json = JSON.toJSONString(model);
        System.out.println(json);
    }


    public static class CusModel {
        @JSONField(serializeUsing = ModelValueSerializer.class)
        public int value;
    }

    public static class ModelValueSerializer implements ObjectSerializer {
        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                          int features) throws IOException {
            Integer value = (Integer) object;
            String text = value + "元";
            serializer.write(text);
        }
    }

    @JSONType(alphabetic = false)
    @Data
    public static class B {
        public int f2;
        public int f1;
        public int f0;
    }
}