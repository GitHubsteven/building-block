package converter.json;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 19:04 2019/4/3.
 */
public class JsonParser {
    private final static String LIST_FLAG = "[";
    private final static String OBJ_FLAG = "{";
    private final static List<String> REF_FLAGS = Arrays.asList(LIST_FLAG, OBJ_FLAG);


    public static void main(String[] args) {
        String json = "{\n" +
                "    \"mappings\": [\n" +
                "        {\n" +
                "            \"articleNumber\": \"ABCD001-002\",\n" +
                "            \"productId\": \"7a1132fff2bbc5daa8d64660b60e7904\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"articleNumber\": \"ABCD002-003\",\n" +
                "            \"productId\": \"-1\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String newJson = json.replaceAll("\\s", "");
        System.out.println(newJson);


        Map<String, TypeInfo> name2Type = new HashMap<>();
    }

    /**
     * 给一个
     */
    public static void parseJson() {

    }

    @Setter
    @Getter
    public static class TypeInfo {
        /**
         * 数据类型
         */
        private String typeName;

        /**
         * 属性成员的信息
         */
        private Map<String, TypeInfo> fieldInfo;
    }

}