package data.structure.book.graph.search.dfs;

import java.util.LinkedList;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://algorithms.tutorialhorizon.com/graph-depth-first-traversal/
 * @Author asa.x
 * @Date: Created at 15:13 2020/3/2.
 */
public class DfsGraph {
    int vertexNum;

    LinkedList<LinkedList<Integer>> vertexes;

    public DfsGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        vertexes = new LinkedList<>();
        for (int i = 0; i < vertexNum; i++) {
            vertexes.add(new LinkedList<>());
        }
    }

    public void addEdge(int from, int to) {
        vertexes.get(from).add(to);
    }

    public void printGraph() {
        for (int i = 0; i < vertexNum; i++) {
            LinkedList<Integer> nodeList = vertexes.get(i);
            if (!nodeList.isEmpty()) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (Integer integer : nodeList) {
                    System.out.print(" " + integer);
                }
            }
            System.out.println();
        }
    }

    public void DFS() {
        System.out.print("Depth First Traversal: ");
        boolean[] isVisited = new boolean[vertexNum];
        for (int i = 0; i < vertexes.size(); i++) {
            dfs(i, isVisited);
        }
    }

    public void dfs(int index, boolean[] isVisited) {
        if (isVisited[index]) return;
        System.out.print(index + " ");
        isVisited[index] = true;
        LinkedList<Integer> connectTos = this.vertexes.get(index);
        for (Integer connectTo : connectTos) {
            if (!isVisited[connectTo]) dfs(connectTo, isVisited);
        }
    }


    public static void main(String[] args) {
        DfsGraph graph = new DfsGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);
        graph.printGraph();
        graph.DFS();
    }
}