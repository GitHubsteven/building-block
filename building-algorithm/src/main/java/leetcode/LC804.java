package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:19 2019/4/10.
 */
public class LC804 {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    /**
     * 网址链接： https://leetcode.com/problems/unique-morse-code-words/
     *
     * @param words 需要加密的单词
     * @return 不同密码的数量
     */
    public static int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;
        String[] morseCodeArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        List<String> difWordInMorse = new ArrayList<>();
        for (String word : words) {
            StringBuilder encodeTmp = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                encodeTmp.append(morseCodeArray[word.charAt(i) - 'a']);
            }
            if (!difWordInMorse.contains(encodeTmp.toString())) {
                difWordInMorse.add(encodeTmp.toString());
            }
        }
        return difWordInMorse.size();
    }
}