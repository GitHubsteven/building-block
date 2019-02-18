package dp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import util.IndListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 15:34
 * @Description: 场景：在行为row，列为col的棋盘上，有些格子有硬币，第一行和第一列没有硬币，
 * 2. 从左上方开始
 * 3. 只能向右或下移动
 * <p>
 * 求：在i,j中，可以得到的最大硬币数
 * <p>
 * 分析：设f(i,j)是可以收取到的最大硬币数，对于i，j，只能是从（i-1,j)或者（i,j-1)来的，那么要求f(i,j)
 * 那么就等于求max{f(i-1,j),f(i,j-1)}+ c(i,j),所以数据逻辑如下：
 * f(i,j) = max{f(i-1,j),f(i,j-1)}+ c(i,j)   1<= i <= n,1<=j<=m
 * <p>
 * f(i,j) = 0                                 i = 0 || j =0
 * @version: 1.0.0
 */
public class CoinCollection {
    private static Integer[][] coinMap = createMap(4, 4);


    public static void main(String[] args) {
        CoinCollection instance = new CoinCollection();
        IndListUtil.printMap(coinMap);
        instance.robotCoinCollect(coinMap);
    }

    /**
     * 输入棋盘，得到能收集到的最大的硬币数
     *
     * @param map 棋盘地图
     * @return
     */
    private int robotCoinCollect(Integer[][] map) {
        int row = map.length;
        int col = map[0].length;
        List<Node> trackingList = new ArrayList<>();
        int maxCoins = getMaxCoins(row, col, map, trackingList);
        System.out.println(maxCoins);
        trackingList.stream().distinct().forEach(node -> {
            System.out.println(String.format("row: %s, col: %s", node.getRow(), node.getCol()));
        });
        return maxCoins;
    }


    /**
     * 求在地图中第row，col行的最大硬币数
     *
     * @param row       行数，从1开始
     * @param col       列数，从1开始
     * @param map       棋盘地图
     * @param trackList 选择的路径
     * @return 获取当前行列的可获取的最大硬币数
     */
    public static int getMaxCoins(int row, int col, Integer[][] map, List<Node> trackList) {
        if (col == 0 || row == 0) {
            return 0;
        } else {
//            int rowRed1Max = getMaxCoins(row - 1, col, map, trackList);
//            int colRud1Max = getMaxCoins(row, col - 1, map, trackList);
//            if (rowRed1Max > colRud1Max) {
//                trackList.add(new Node(row - 1, col));
//                return rowRed1Max + map[row - 1][col - 1];
//            } else {
//                trackList.add(new Node(row, col - 1));
//                return colRud1Max + map[row - 1][col - 1];
//            }
            return Math.max(getMaxCoins(row - 1, col, map, trackList), getMaxCoins(row, col - 1, map, trackList)) + map[row - 1][col - 1];
        }
    }


    /**
     * 生成地图
     *
     * @param row 行
     * @param col 列
     * @return 赋值了的地图
     */
    public static Integer[][] createMap(int row, int col) {
        Random random = new Random();
        Integer[][] map = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = random.nextInt(2);
                }
            }
        }
        return map;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    static class Node {
        private Integer row;
        private Integer col;

        @Override
        public boolean equals(Object obj) {
            Node compareObj = (Node) (obj);
            return this.row.equals(compareObj.getRow()) && this.col.equals(compareObj.getCol());
        }
    }
}