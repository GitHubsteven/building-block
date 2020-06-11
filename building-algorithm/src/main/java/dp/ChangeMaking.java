package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 10:18
 * @Description: make up amount n by coins{d1,d2,....,dn}, find the least coins number
 * ps: coins must have coin value 1
 * @version: 1.0.0
 */
public class ChangeMaking {
    public static void main(String[] args) {
        int[] values = {1, 3, 4};
        int coinMin = changeMaking(values, 10);
        System.out.println(coinMin);

    }

    /**
     * make up amount n by coin{d1,d2,....,dn}, find the least coins number
     * coins must have coin value 1
     *
     * @param values coin value
     * @param amount amount
     * @return least coins count
     */
    static int changeMaking(int[] values, int amount) {
        if (amount == 0) return 0;
        if (amount == 1) return 1;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < values.length - 1 && values[i] <= amount; i++) {
            int temp = changeMaking(values, amount - values[i]);
            if (temp < min) {
                min = temp;
            }
        }
        return min + 1;
    }

    /**
     * how many ways to collection  amount
     * f(n)= Σ(0-i && value[i] < amount) f(n)
     *
     * @param values coin values
     * @param amount target money
     * @return total ways number
     */
    static int getWayCnt(int[] values, int amount) {
        if (amount == 0) return 1;
        if (amount == 1) return 1;
        if (amount < 0) return -1;
        int sum = 0;
        for (int i = 0; i < values.length && values[i] <= amount; i++) {
            System.out.println("========tracking======amount: " + amount + " coin values: " + values[i]);
            sum += getWayCnt(values, amount - values[i]);
        }
        return sum;
    }
}