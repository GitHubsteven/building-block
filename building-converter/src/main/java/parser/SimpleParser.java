package parser;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 18:35 2019/5/25.
 */
public class SimpleParser implements IParser {
    private static List<String> separators = Arrays.asList("");

    /**
     * 解析句子
     *
     * @param sentence 句子
     * @return 属性解析信息
     */
    @Override
    public FieldInfo parseSentence(String sentence) {
        if (sentence.startsWith("\\")) return FieldInfo.stringField();
        String s1 = sentence.replaceFirst("\\{", "");
        return new FieldInfo().setFieldName("");
    }

    public static void main(String[] args) {
        String senetence = "{\n" +
                "\t\"name\": {\n" +
                "\t\t\"name\": {\n" +
                "\t\t\t\"name\": \"asa\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        String sentence = senetence.replaceAll("\\n+|\\t+", "");
        System.out.println(sentence);
    }


}