package converter.json.fastjson.custom.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/25
 * @Time: 18:46
 * @Description:
 * @version: 1.0.0
 */
public class CharacterSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type type, int i) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        Character value = (Character) object;
        if (value == null) {
            out.write("");
            return;
        }

        char c = value.charValue();
        if (c == 0) {
            out.writeString("\u0000");
        } else {
            out.writeString(value.toString());
        }
    }

}