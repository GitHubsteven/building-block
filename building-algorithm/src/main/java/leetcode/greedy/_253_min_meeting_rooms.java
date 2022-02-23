package leetcode.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _253_min_meeting_rooms {
    public static void main(String[] args) {
        int[][] meetings = {{7, 10}, {2, 4}};
        System.out.println(bruce_force(meetings));
    }

    public static int minMeetingRooms(int[][] intervals) {
        return 0;
    }

    /**
     * 暴力枚举：并不能满足需求
     *
     * @param intervals 会议时间
     */
    public static int bruce_force(int[][] intervals) {
        int count = 1;
        List<List<int[]>> roomsInNeed = new ArrayList<>();
        roomsInNeed.add(createNewRoom(intervals[0]));
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean isArranged = false;
            // 遍历会议室
            for (int j = 0; j < count; j++) {
                List<int[]> room = roomsInNeed.get(j);
                // 遍历当前会议室所有会议，看是否可以安排进去
                for (int x = 0; x < room.size() - 1; x++) {
                    // 判断是否可以在当前会议和后面一个会议之间，如果可以，那么插入这个会议之后
                    if (room.get(x)[1] < start && room.get(x + 1)[0] > end) {
                        room.add(x + 1, intervals[i]);
                        isArranged = true;
                        break;
                    }
                }
                // 判断是否安排了会议室，如果安排了，中断后续会议室的遍历
                if (isArranged) break;
            }
            // 如果未安排，那么需要新的会议室
            if (!isArranged) {
                roomsInNeed.add(createNewRoom(intervals[i]));
                count++;
            }
        }
        return count;
    }

    /**
     * 创建一个新的会议室，但是会议室必须有至少一个会议室，并且开头和结尾都增加了两个空会议，作为哨兵
     *
     * @param firstMeeting 第一个会议
     * @return 会议室
     */
    static List<int[]> createNewRoom(int[] firstMeeting) {
        List<int[]> room = new LinkedList<>();
        room.add(new int[]{0, 0});
        room.add(firstMeeting);
        room.add(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
        return room;
    }
}
