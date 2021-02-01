package leetcode.dp;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/28
 * @description https://leetcode.com/problems/divisor-game/
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Lc_1025 {
    public static void main(String[] args) {

    }

    /**
     * 谁最后拿的数字是2，那么在选择1，那么谁就会赢
     * <p>
     * 奇数的因数必定是因数，所以，N-x后，那么必定是偶数
     * 偶数的因数可以为奇数，也可以为偶数
     * 但是有一个因子，1，可以将奇数和偶数关系逆转
     * 所以，如果两者都做最优解的话，那么第一个拿到偶数的人，永远可以保持自己是偶数
     * 最后的2将会保留到最后，那么就赢了
     * <p>
     * 所以只要判断alice是否拿的是偶数就可以了，是的话就赢了，否则就输了。
     *
     * @param N 给定的数字
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
