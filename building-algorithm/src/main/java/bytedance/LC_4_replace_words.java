/**
 * @author: asx
 * @date: 2023/6/29
 * @descrition:
 */
package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: asx
 * @date: 2023/6/29
 * @descrition: https://leetcode.cn/problems/replace-words/?envType=study-plan-v2&envId=bytedance-2023-spring-sprint
 */
public class LC_4_replace_words {
    public static String replaceWords(List<String> dictionary, String sentence) {
        //字母匹配问题
        // 对单词进行词根便利，单词遵循规则词根+xxx,假设当前匹配的词根是最小的词根，直接代替
        // 直到后面可以代替当前的词根的词根
        String[] words = sentence.split(" ");
        List<String> roots = new ArrayList<>(words.length);
        for (String word : words) {
            // 对单词进行词根匹配
            for (String doc : dictionary) {
                if (word.startsWith(doc)) {
                    word = doc;
                }
            }
            roots.add(word);
        }
        return String.join(" ", roots);
    }
}
