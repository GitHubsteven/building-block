package converter.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.BusinessException;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/24
 * @Time: 20:29
 * @Description:
 * @version: 1.0.0
 */
public final class JacksonUtils {
    public JacksonUtils() {
    }

    public static String bean2Json(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();

        JsonGenerator gen;
        try {
            gen = (new JsonFactory()).createGenerator(sw);
            mapper.writeValue(gen, obj);
        } catch (IOException var6) {
            throw new BusinessException(var6.getMessage(), var6);
        }

        if (gen != null) {
            try {
                gen.close();
            } catch (IOException var5) {
                throw new BusinessException(var5.getMessage(), var5);
            }
        }

        return sw.toString();
    }

    public static String bean2JsonNotNull(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JsonGenerator gen;
        try {
            gen = (new JsonFactory()).createGenerator(sw);
            mapper.writeValue(gen, obj);
        } catch (IOException var6) {
            throw new BusinessException(var6.getMessage(), var6);
        }

        if (gen != null) {
            try {
                gen.close();
            } catch (IOException var5) {
                throw new BusinessException(var5.getMessage(), var5);
            }
        }

        return sw.toString();
    }

    public static <T> T json2Bean(String jsonStr, Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return mapper.readValue(jsonStr, cls);
        } catch (IOException var4) {
            throw new BusinessException(var4.getMessage(), var4);
        }
    }

    public static <T> T json2BeanWithDateCovert(String jsonStr, Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(format);

        try {
            return mapper.readValue(jsonStr, cls);
        } catch (IOException var5) {
            throw new BusinessException(var5.getMessage(), var5);
        }
    }

    public static Map<String, Object> jsonToMap(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return (Map)mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> List<T> jsonToBeanList(String jsonString, Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametrizedType(ArrayList.class, List.class, new Class[]{cls});

        try {
            return (List)mapper.readValue(jsonString, javaType);
        } catch (IOException var5) {
            throw new RuntimeException(var5);
        }
    }

    public static List<Map<String, Object>> jsonToMapList(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametrizedType(ArrayList.class, List.class, new Class[]{Map.class});

        try {
            return (List)mapper.readValue(jsonString, javaType);
        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static <T> T ToObjectFromJson(String json, Class<T> cls) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, cls);
    }

    public static Map<String, Object> bean2Map(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        return (Map)mapper.convertValue(obj, new TypeReference<Map<String, Object>>() {
        });
    }
}