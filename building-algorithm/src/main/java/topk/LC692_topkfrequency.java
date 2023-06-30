/**
 * @author: asx
 * @date: 2023/6/29
 * @descrition:
 */
package topk;

import java.util.*;

/**
 * @author: asx
 * @date: 2023/6/29
 * @descrition:
 */
public class LC692_topkfrequency {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("i", "love", "leetcode", "i", "love", "coding");
        List<String> topkFreq = topKFrequent(words.toArray(new String[0]), 2);
        System.out.println(topkFreq);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> word2Frequent = new HashMap<>(words.length);
        // n
        for (String word : words) {
            Integer number = word2Frequent.get(word);
            if (number == null) {
                number = 1;
            } else {
                number += 1;
            }
            word2Frequent.put(word, number);
        }

        Map<Integer, List<String>> freq2Words = new HashMap<>(words.length);
        word2Frequent.forEach((word, num) -> {
            List<String> ws = freq2Words.get(num);
            if (ws == null) {
                ws = new ArrayList<>();
                ws.add(word);
                freq2Words.put(num, ws);
            } else {
                ws.add(word);
            }
        });
        List<String> topkWords = new ArrayList<>(k);
        int count = 0;
        Integer[] sortedKeys = freq2Words.keySet().toArray(new Integer[0]);
        for (int i = sortedKeys.length; i > 0; i--) {
            Integer key = sortedKeys[i - 1];
            List<String> list = freq2Words.get(key);
            list.sort(String::compareTo);
            if (count >= k) {
                break;
            }
            for (String word : list) {
                if (count >= k) {
                    break;
                } else {
                    topkWords.add(word);
                    count++;
                }
            }
        }
        return topkWords;
    }
}
