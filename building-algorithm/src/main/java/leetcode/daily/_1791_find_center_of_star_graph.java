package leetcode.daily;

public class _1791_find_center_of_star_graph {
    public static void main(String[] args) {
    }

    public static int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ?
                edges[0][0]
                : edges[0][1];
    }
}
