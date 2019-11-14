package interviewee;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:29 2019/10/17.
 */
public class CountEvenArea {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 9, 4, 1,2,4,1,100};
        System.out.println(countEvenArea(numbers));;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * 偶数区间始于偶数，终于奇数或终点，当sum为正的时候，如果如果当前为奇数或重点，那么count ++
     * <p>
     * 1.如果当前为奇数
     * 1.1 起始位置为偶数，那么count ++ && 其实位置为负数
     * 1.2 起始位置为奇数，那么继续，直到结束
     * 2 如果当前为偶数
     * 2.1 起始为偶数
     * 2.1.1 如果是终点，那么count++
     * 2.1.2 继续
     * 2.2 起始为奇数，标志位变为正
     *
     * @param numbers 数字集合
     * @return 偶数区间数目
     */
    public static int countEvenArea(int[] numbers) {
        int sum = 0;
        boolean isStartEven = false;
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            int val = numbers[i];
            if (isEven(val)) {
                if (!isStartEven) isStartEven = true;
            } else {
                if (isStartEven) sum++;
            }
        }
        //最后一个数字特殊处理
        if (isEven(numbers[length - 1])) {
            sum++;
        } else {
            if (isStartEven) sum++;
        }
        return Math.abs(sum);
    }
}