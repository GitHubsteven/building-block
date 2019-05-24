package parser;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:14 2019/5/17.
 */
public interface IParser {
    /**
     * 解析句子
     *
     * @param sentence 句子
     * @return 属性解析信息
     */
    FieldInfo parseSentence(String sentence);
}