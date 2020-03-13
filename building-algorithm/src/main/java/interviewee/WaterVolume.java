package interviewee;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 18:30 2020/3/12.
 */
public class WaterVolume {
    public static void main(String[] args) {
        int[] data = {9,7,6,2,1};
        System.out.println(waterVolume(data));
    }

    /**
     * readme.md for more details
     * <p>
     * example1:
     * input:[0,1,0,2,1,0,1,3,2,1,2,1]
     * output:6
     *
     * @param heights the height of cube
     */
    public static int waterVolume(int[] heights) {
        int sum = 0;
        int idx = 0;
        int pool_start = -1;
        while (idx < heights.length) {
            int cur = heights[idx];
            if (pool_start == -1) {
                //find the first pool_start;
                if (idx == heights.length - 1) {
                    idx++;
                } else if (cur > heights[idx + 1]) {
                    pool_start = idx++;
                } else idx++;
            } else {
                //find the pool_end
                if (cur > heights[idx - 1]) {
                    int pool_start_value = heights[pool_start];
                    if (cur == pool_start_value   // pool upper bound
                            || idx == heights.length - 1   //all bound
                            || (cur > pool_start_value && heights[idx - 1] < pool_start_value)  //indirectly inflexion
                            || heights[idx + 1] < cur) {       //directly inflexion
                        //end cur pool
                        sum += calPoolWater(pool_start, idx, heights);
                        pool_start = -1;
                    } else {
                        idx++;
                    }
                } else {
                    idx++;
                }
            }
        }
        return sum;
    }

    private static int calPoolWater(int start, int end, int[] heights) {
        System.out.println(String.format("pool start at: %d, end at :%s", start, end));
        int pool_top = Math.min(heights[start], heights[end]);
        int extract_volume = 0;
        for (int i = start + 1; i < end; i++) {
            extract_volume = extract_volume + heights[i];
        }
        return pool_top * (end - start - 1) - extract_volume;
    }
}