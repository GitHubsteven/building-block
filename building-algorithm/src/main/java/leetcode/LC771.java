package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:38 2019/4/10.
 */
public class LC771 {
    public static void main(String[] args) {
        //test case 1
        String j1 = "aA", s1 = "aAAbbbb";
        System.out.println(jewelsAndStones(j1, s1));
    }

    public static int jewelsAndStones(String jewels, String stones) {
        int sum = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) > -1) sum++;
        }
        return sum;
    }
}