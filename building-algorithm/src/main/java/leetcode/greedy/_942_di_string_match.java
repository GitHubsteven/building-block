package leetcode.greedy;

public class _942_di_string_match {

    public static void main(String[] args) {
        for (int i : diStringMatch("III")) {
            System.out.printf("%d\t", i);
        }
    }

    /**
     * https://leetcode-cn.com/problems/di-string-match/
     *
     * @param s string解析
     * @return 满足条件的一个case
     */
    public static int[] diStringMatch(String s) {
        int length = s.length();
        // 所以数字为：[0,1,....,length]
        int min = 0, max = length;
        int[] answer = new int[length + 1];
        for (int i = 0; i < length; i++) {
            char cur = s.charAt(i);
            if (cur == 'D') {
                answer[i] = max--;
            } else {
                answer[i] = min++;
            }
        }
        answer[length] = max;
        return answer;
    }
}
