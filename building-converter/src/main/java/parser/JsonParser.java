package parser;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:13 2019/5/17.
 */
public class JsonParser {
    /**
     * 根据json格式的文本转化class的内容
     *
     * @param json json 格式文本
     * @return java class的文本内容
     */
    public static String parse(String json, IParser iParser) {
        String[] sentences = json.split("\\n*，+");
        for (String sentence : sentences) {
            iParser.parseSentence(sentence);
        }
    }

}