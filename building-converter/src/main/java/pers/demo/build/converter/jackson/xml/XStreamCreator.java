package pers.demo.build.converter.jackson.xml;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import converter.json.jackson.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/26
 * @Time: 17:24
 * @Description: XStream辅助类
 * @version: 1.0.0
 */
public class XStreamCreator {
    private static final ObjectMapper OM = new ObjectMapper();

    public static XStream buildXStream() {
        XStream xStream = new XStream();
        registerComConvert(xStream);
        return xStream;
    }

    public static void registerComConvert(final XStream xStream) {
        xStream.registerConverter(new DoubleConverter() {

            @Override
            public Object fromString(String str) {
                if (StringUtils.isAllBlank(str)) {
                    return null;
                }
                return super.fromString(str);
            }
        });
        xStream.registerConverter(new LongConverter() {

            @Override
            public Object fromString(String str) {
                if (StringUtils.isAllBlank(str)) {
                    return null;
                }
                return super.fromString(str);
            }
        });
        xStream.registerConverter(new IntConverter() {

            @Override
            public Object fromString(String str) {
                if (StringUtils.isAllBlank(str)) {
                    return null;
                }
                return super.fromString(str);
            }
        });

        xStream.registerConverter(new DateConverter() {

            @Override
            public Object fromString(String str) {
                if (StringUtils.isAllBlank(str)) {
                    return null;
                } else {
                    return DateTimeUtils.parse(str, DateTimeUtils.DEFAULT_DATETIME_FORMAT);
                }
            }

            @Override
            public String toString(Object obj) {
                if (null == obj) {
                    return null;
                } else {
                    Date source = (Date) obj;
                    return DateTimeUtils.format(source, DateTimeUtils.DEFAULT_DATETIME_FORMAT);
                }
            }
        });

    }

    public static class MapEntryConverter implements Converter {
        private static final ObjectMapper OM = new ObjectMapper();

        static {
            OM.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
            OM.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        }

        @Override
        public boolean canConvert(Class clazz) {
            return AbstractMap.class.isAssignableFrom(clazz);
        }

        @Override
        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            if (value != null) {
                AbstractMap map = (AbstractMap) value;
                String jsonStr;
                try {
                    jsonStr = OM.writeValueAsString(map);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    throw new IllegalArgumentException("map参数反序列化失败，请检查下Map " + value.toString() + "参数");
                }
                writer.setValue(jsonStr);
            }
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            String value = reader.getValue();
            if (!StringUtils.isAllBlank(value)) {
                try {
                    return analysisRespMapResult(value);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new IllegalArgumentException("map参数反序列化失败，请检查下Map " + reader.getNodeName() + "参数");
                }
            }
            return null;
        }

    }

    public static class TimeZoneDateConverter extends DateConverter {
        public TimeZoneDateConverter(String dateFormat) {   //DateTimeUtils.DEFAULT_DATETIME_FORMAT
            super(dateFormat, new String[]{dateFormat}, TimeZone.getTimeZone("GMT+8")); // 传入的时间是正8区的时间
        }
    }

    private static Map<String, Object> analysisRespMapResult(String resultStr) throws Exception {
        boolean isJson = resultStr.startsWith("{");
        Map<String, Object> result;
        //当前只有json格式和，用；分开的map类型
        if (isJson) {
            //noinspection unchecked
            result = OM.readValue(resultStr, Map.class);
        } else {
            result = new HashMap<>();
            String[] statements = resultStr.split(";");
            for (String state : statements) {
                String[] key2Value = state.split(":");
                if (key2Value.length == 2) {
                    result.put(key2Value[0], key2Value[1]);
                } else {
                    result.put(key2Value[0], null);
                }
            }
        }
        return result;
    }
}