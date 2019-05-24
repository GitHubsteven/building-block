package parser;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:37 2019/5/17.
 */
public class DefaultParser implements IParser {
    @Override
    public FieldInfo parseSentence(String sentence) {
        String[] expect2val = sentence.split(":");
        if (expect2val.length != 2) throw new RuntimeException("wrong json");

        return null;
    }

}