package util;

import bean.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: emoji 标志非正常字符，不仅仅表示emoji字符
 * @Date: Created at 15:09 2019/6/6.
 */
public class EmojiUtils {
    private static ObjectMapper OM = new ObjectMapper();


    private static final String EMOJI_CHAR = "[^\\u0000-\\uFFFF]";
    private static final Pattern compile = Pattern.compile(EMOJI_CHAR);


    /**
     * 检测是否有emoji字符
     *
     * @param source 检测的字符
     * @return boolean型
     */
    public static boolean containsEmoji(String source) {
        Matcher matcher = compile.matcher(source);
        return matcher.find();
    }

    /**
     * 移除emoji表情
     *
     * @param source 来源字符
     * @return 移除emoji表情后的字符
     */
    public static String filterEmoji(String source) {
        return source.replaceAll(EMOJI_CHAR, "");
    }

    /**
     * 获取emoji表情
     *
     * @param source 字符来源
     * @return 字符中包含的emoji表情
     */
    public static List<String> getEmojis(String source) {
        List<String> emojis = new ArrayList<>();
        Matcher matcher = compile.matcher(source);
        while (matcher.find()) {
            emojis.add(matcher.group());
        }
        return emojis;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setName("孟磊\uD83D\uDE05");
        person.setAge(2);
        System.out.println(containsEmoji(OM.writeValueAsString(person)));
        System.out.println(OM.writeValueAsString("ABCD"));
    }


}