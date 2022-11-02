package leetcode;

public class _1189_maxNumberOfBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }

    /**
     * balloon
     *
     * @param text
     * @return
     */
    public static int maxNumberOfBalloons(String text) {
        int[] cnts = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') cnts[0]++;
            else if (c == 'a') cnts[1]++;
            else if (c == 'l') cnts[2]++;
            else if (c == 'o') cnts[3]++;
            else if (c == 'n') cnts[4]++;
        }
        cnts[2] /= 2;
        cnts[3] /= 2;
        int ans = cnts[0];
        for (int i = 0; i < 5; i++) ans = Math.min(ans, cnts[i]);
        return ans;
    }
}
