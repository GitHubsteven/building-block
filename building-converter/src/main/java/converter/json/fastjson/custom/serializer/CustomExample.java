package converter.json.fastjson.custom.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/25
 * @Time: 18:52
 * @Description:
 * @version: 1.0.0
 */
public class CustomExample {
    public static class Msg {
        public JsonEnum.OrderActionEnum actionEnum;
        public String body;
    }

    public static class OrderActionEnumDeser implements ObjectDeserializer {
        @SuppressWarnings("unchecked")
        @Override
        public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
            Integer intValue = parser.parseObject(int.class);
            if (intValue == 1) {
                return (T) JsonEnum.OrderActionEnum.FAIL;
            } else if (intValue == 0) {
                return (T) JsonEnum.OrderActionEnum.SUCC;
            }
            throw new IllegalArgumentException();
        }

        @Override
        public int getFastMatchToken() {
            return JSONToken.LITERAL_INT;
        }
    }

}