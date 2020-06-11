package converter.json.jackson;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/10
 * @description 关于jackson中数据类型的转化
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class ReadValueTest {
    public static void main(String[] args) throws IOException {
        //单个和map
//        singleAndMap();
//        json2List();
//        json2List2();
//        json2MapList();
        convert();
    }

    private static void singleAndMap() throws IOException {
        Staff staff = getStaff();
        String json = JacksonUtils.bean2Json(staff);
        System.out.println(json);
        Staff newStaff = JacksonConstant.OM.readValue(json, Staff.class);
        System.out.println(newStaff.getName());
        //from type

        Staff fromType = fromType(json, Staff.class);
        if (fromType == null) throw new RuntimeException("error parse type result!");
        System.out.println(fromType.getName());

        //from parameterizedType
        Map<String, Staff> staffMap = new HashMap<>(1);
        staffMap.put("1", staff);
        String staffMapJson = JacksonUtils.bean2JsonNotNull(staffMap);
        Map<String, Staff> json2Map = JacksonConstant.OM.readValue(staffMapJson, new TypeReference<Map<String, Staff>>() {
        });
        json2Map.forEach((key, value) -> {
            System.out.println(key + " " + value.getName());
        });
    }

    protected static Staff getStaff() {
        return new Staff().setAge(1)
                .setName("rb.x")
                .setPosition("sh")
                .setSalary(new BigDecimal("100.23"))
                .setSkills(Arrays.asList("java", "mysql"));
    }

    public static Staff fromType(String json, Type type) throws IOException {
        Object obj = JacksonConstant.OM.readValue(json, JacksonConstant.OM.constructType(type));
        if (obj instanceof Staff) {
            return (Staff) obj;
        }
        return null;
    }

    /**
     * json ot list
     *
     * @return List<T>
     * @throws IOException
     */
    public static List<Staff> json2List() throws IOException {
        String json = "[{\"name\":\"rb.x\",\"age\":1,\"position\":\"sh\",\"salary\":100.23,\"skills\":[\"java\",\"mysql\"]}]";
        //在反序列化为List的过程中，list<T> 和Map<K,V>本质上是parameterizedType
        List<Staff> staffList = JacksonConstant.OM.readValue(json, new TypeReference<List<Staff>>() {
        });
        System.out.println(staffList.size());
        return staffList;
    }

    /**
     * json to list 2
     *
     * @return list<T>
     * @throws IOException
     */
    public static List<Staff> json2List2() throws IOException {
        String json = "[{\"name\":\"rb.x\",\"age\":1,\"position\":\"sh\",\"salary\":100.23,\"skills\":[\"java\",\"mysql\"]}]";
        //在反序列化为List的过程中，list<T> 和Map<K,V>本质上是parameterizedType
        List<Staff> staffList = JacksonConstant.OM.readValue(json, JacksonConstant.OM.getTypeFactory().constructCollectionType(List.class, Staff.class));
        System.out.println(staffList.size());
        return staffList;
    }

    public static Map<String, Staff>[] json2MapList() throws IOException {
        String mapArrayJson = "[{\"id_1\":{\"name\":\"rb.x\",\"age\":1,\"position\":\"sh\",\"salary\":100.23,\"skills\":[\"java\",\"mysql\"]}}]";
        Map<String, Staff>[] mapArray = JacksonConstant.OM.readValue(mapArrayJson, JacksonConstant.OM.getTypeFactory()
                .constructArrayType(JacksonConstant.OM.getTypeFactory().constructMapType(Map.class, String.class, Staff.class)));
        System.out.println(mapArray[0].get("id_1").getName());
        return mapArray;
    }

    /**
     * 类型转化
     */
    public static void convert() {
        Staff staff = getStaff();
        StaffWrapper wrapper = new StaffWrapper("id_1", staff);
        Map<String, Object> map = JacksonConstant.OM.convertValue(wrapper, new TypeReference<Map<String, Object>>() {
        });
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }
}
