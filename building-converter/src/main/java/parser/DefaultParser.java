package parser;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:37 2019/5/17.
 */
public class DefaultParser implements IParser {
    private static String separators = "[{:}]";

    public static void main(String[] args) {
        char val = '{';
        System.out.println(separators.indexOf(val));
    }


    @Override
    public FieldInfo parseSentence(String sentence) {
        String[] expect2val = sentence.split(":");
        int length = expect2val.length;
        if (length == 1) return FieldInfo.stringField();
        return null;
    }

}