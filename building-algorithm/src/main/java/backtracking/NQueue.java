package backtracking;

import util.CollectionHelper;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/7/9
 * @description N皇后问题： https://juejin.im/post/5accdb236fb9a028bb195562
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class NQueue {
    private final static int QUEUE_SIZE = 8;
    private final static int[][] CHESS_BOARD = new int[QUEUE_SIZE][QUEUE_SIZE];
    /**
     * 记录回溯皇后过程的索引
     */
    private final static int[] QUEUE_LOCATIONS = new int[QUEUE_SIZE];

    public static void main(String[] args) {
        locateQueue(1);
        CollectionHelper.printArray(QUEUE_LOCATIONS);
    }

    public static void locateQueue(int queue) {
        if (queue > QUEUE_SIZE || queue < 1) return;
        int curLocation = QUEUE_LOCATIONS[queue - 1];
        if (curLocation > 0) {
            // back track and clear value to get the right next location
            setValue(queue, curLocation, true);
        }
        int newLocation = findLocation(queue);
        // 很重要，因为可能有的情形下，会回溯到N>1个前，所以要及时的更新回溯的数据
        QUEUE_LOCATIONS[queue - 1] = 0;
        if (newLocation > 0) {
            // set value by new location
            setValue(queue, newLocation, false);
            QUEUE_LOCATIONS[queue - 1] = newLocation;
            locateQueue(queue + 1);
        } else {
            //back track
            locateQueue(queue - 1);
        }
    }

    public static int findLocation(int queue) {
        int[] queueRaw = CHESS_BOARD[queue - 1];
        int curQueueLocation = QUEUE_LOCATIONS[queue - 1];
        int idx = curQueueLocation == 0 ? 1 : curQueueLocation + 1;
        for (; idx <= queueRaw.length; idx++) {
            if (queueRaw[idx - 1] == 0) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * 皇后赋值操作
     *
     * @param raw     行的索引，从1开始，其实也是皇后的索引代号
     * @param col     列的索引，从1开始
     * @param isClear 是否清除，否则就是占用
     */
    public static void setValue(int raw, int col, boolean isClear) {
        // set raw element as occupied-> value
        for (int idx = 1; idx <= QUEUE_SIZE; idx++) {
            assign(raw, idx, isClear, raw);
        }
        // set col element as occupied -> value
        for (int idx = 1; idx <= QUEUE_SIZE; idx++) {
            assign(idx, col, isClear, raw);
        }
        // 斜角函数是可以被优化的，只需要找到左上角和左下角就可以了，然后做斜率为1|-1的操作 + 边界的判断就好了
        // set the oblique line element -> value
        int back = Math.max(raw, col);
        while (back > 0) {
            if (col - back > 0 && raw - back > 0) {
                assign(raw - back, col - back, isClear, raw);
            }
            if (col - back > 0 && raw + back <= QUEUE_SIZE) {
                assign(raw + back, col - back, isClear, raw);
            }
            back--;
        }
        //forward
        int forward = QUEUE_SIZE - Math.min(raw, col);
        while (forward > 0) {
            if (col + forward <= QUEUE_SIZE && raw - forward > 0) {
                assign(raw - forward, col + forward, isClear, raw);
            }
            if (col + forward <= QUEUE_SIZE && raw + forward <= QUEUE_SIZE) {
                assign(raw + forward, col + forward, isClear, raw);
            }
            forward--;
        }
    }

    public static void assign(int raw, int col, boolean isClear, int expectQueue) {
        //删除因为expectQueue
        if (isClear && CHESS_BOARD[raw - 1][col - 1] == expectQueue) CHESS_BOARD[raw - 1][col - 1] = 0;
        if (!isClear && CHESS_BOARD[raw - 1][col - 1] == 0) CHESS_BOARD[raw - 1][col - 1] = expectQueue;
    }

}
