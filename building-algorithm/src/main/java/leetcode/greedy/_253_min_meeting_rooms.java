package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class _253_min_meeting_rooms {
    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
    }

    public static int minMeetingRooms(int[][] intervals) {
        // TODO: 2022/2/16
        int count = 1;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int index = -1, min;
        for (int j = 1; j < intervals.length; j++) {
            min = Integer.MAX_VALUE;
            index = -1;
            for (int i = 0; i < count; i++) {
                // 如果当前开始时间>会议室被占用的起始时间，那么就插到前面，然后记录当前间隔时间为最小浪费时间
                if (intervals[j][1] < list.get(i)[0]) {
                    if (Math.abs(list.get(i)[0] - intervals[j][1]) < min) {
                        index = i;
                        min = list.get(i)[0] = intervals[j][0];
                    }
                } else if (intervals[j][0] > list.get(i)[1]) {

                }
            }
        }
        return 0;
    }
}
