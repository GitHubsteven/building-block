package data.structure.book.graph.search.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @Authoer: asa.x
 * @Date: 2020/2/12
 * @Descrition: url: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class Graph {
    private int V; //no of vertices

    private LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        Arrays.fill(adj, new LinkedList<>());
    }

    //describe a digraph
    void addEdge(int from, int to) {
        adj[from].add(to);   //add w to v's adj list
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        ListIterator<Integer> iterator = adj[v].listIterator();
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            if (!visited[n]) DFSUtil(n, visited);
        }
    }

    void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }

    /**
     * dfs for the disconnected graph
     */
    void DFS4DisconnectedGraph() {
        boolean[] visited = new boolean[V];
        for (int index = 0; index < V; index++) {
            if (!visited[index])
                DFSUtil(index, visited);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        graph.DFS(2);
    }
}
