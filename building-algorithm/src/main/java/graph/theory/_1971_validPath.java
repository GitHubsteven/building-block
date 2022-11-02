package graph.theory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _1971_validPath {
    public static void main(String[] args) {
        int n = 5, start = 0, end = 0;
        int[][] edges = {{0, 0}};

        System.out.println(validPath(n, edges, start, end));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] isConnected = new boolean[n][n];
        // 初始化边
        for (int[] edge : edges) {
            isConnected[edge[0]][edge[1]] = true;
            isConnected[edge[1]][edge[0]] = true;
        }
        /*
        查看当前节点的下一节点是否包含目标节点，如果是那么表示可以到达，否则不可以
         */
        boolean[] hasVisited = new boolean[n];
        hasVisited[destination] = true;
        return isCurConnected(isConnected, destination, source, hasVisited);
    }

    static boolean isCurConnected(boolean[][] isConnected, int cur, int source, boolean[] hasVisited) {
        if (cur == source) return true;
        if (cur < 0) return false;
        if (cur >= isConnected.length) return false;
        if (isConnected[cur][source]) {
            hasVisited[cur] = true;
            return true;
        }
        boolean isArrive = false;
        for (int i = 0; i < isConnected.length; i++) {
            if (cur == i) continue;
            if (isConnected[cur][i]) {
                if (hasVisited[i]) continue;
                hasVisited[i] = true;
                isArrive = isCurConnected(isConnected, i, source, hasVisited);
                if (isArrive) break;
            }
        }
        hasVisited[cur] = true;
        return isArrive;
    }


    public boolean online(int n, int[][] edges, int start, int end) {
        boolean cameBefore[] = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        return hasPath(edges, start, end, cameBefore, map);
    }

    public boolean hasPath(int[][] edges, int start, int end, boolean[] cameBefore, Map<Integer, Set<Integer>> map) {
        if (start == end) {
            return true;
        }
        if (cameBefore[start]) {
            return false;
        }
        cameBefore[start] = true;
        for (int a : map.get(start)) {
            if (hasPath(edges, a, end, cameBefore, map)) {
                return true;
            }
        }
        //cameBefore[start]=true  注意此处没有必要，如果之前的线路来过发现不通，那么后来的线路也不通，如果加上反而会超时
        return false;
    }

}
