package jdk.generic.basic.action;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:34 2019/3/21.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, ThreeFunction<String, Integer, String>> operationMap = new HashMap<>();
        operationMap.put("1", (str, in2) -> str + in2);
        operationMap.put("2", (str, in2) -> str + 2 * in2);

        String result = operationMap.get("1").apply("1", 10);
    }
}