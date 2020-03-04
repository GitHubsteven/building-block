package data.structure.book.graph.search.dfs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://www.baeldung.com/java-depth-first-search
 * detail url: https://algorithms.tutorialhorizon.com/topological-sort/
 * @Author asa.x
 * @Date: Created at 18:36 2020/3/2.
 */
public class TopLogicalSort {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination) {
            adjList[source].addFirst(destination);
        }

        public void topologicalSorting() {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            //visit from each node if not already visited
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) topologicalUtils(i, visited, stack);
            }

            System.out.println("Topological Sort: ");
            int size = stack.size();
            for (int i = 0; i <size ; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        public void topologicalUtils(int start, boolean[] visited, Stack<Integer> stack) {
            visited[start] = true;
            for (int i = 0; i < adjList[start].size(); i++) {
                Integer vertex = adjList[start].get(i);
                if (!visited[vertex]) topologicalUtils(vertex, visited, stack);
            }
            stack.push(start);
        }

    }

    public static void main(String[] args) {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEgde(7, 6);
        graph.addEgde(7, 5);
        graph.addEgde(6, 4);
        graph.addEgde(6, 3);
        graph.addEgde(5, 4);
        graph.addEgde(5, 2);
        graph.addEgde(3, 1);
        graph.addEgde(2, 1);
        graph.addEgde(1, 0);
        graph.topologicalSorting();
    }
}