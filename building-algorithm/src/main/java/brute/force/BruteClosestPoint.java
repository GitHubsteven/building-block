package brute.force;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @Authoer: asa.x
 * @Date: 2020/7/30
 * @Descrition:
 */
public class BruteClosestPoint {
    public static void main(String[] args) {
        Point[] points = {new Point(1, 3), new Point(2, 4), new Point(100, 19)};
        System.out.println(bruteClosestPoint(points));
    }

    /**
     * 求出最近的两个点的距离的平方
     *
     * @param points 点集合
     * @return 最近两个点的距离平方
     */
    private static int bruteClosestPoint(Point[] points) {
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            Point start = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int dis = (start.x - points[j].x) * (start.x - points[j].x) + (start.y - points[j].y) * (start.y - points[j].y);
                if (dis < closest) {
                    closest = dis;
                }
            }
        }
        return closest;
    }


    @AllArgsConstructor
    static class Point {
        int x;
        int y;
    }
}
