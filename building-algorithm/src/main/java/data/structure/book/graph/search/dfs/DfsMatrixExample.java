package data.structure.book.graph.search.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://java2blog.com/depth-first-search-in-java/
 * @Author asa.x
 * @Date: Created at 17:51 2020/3/2.
 */
public class DfsMatrixExample {
    static class Node {
        int value;
        boolean isVisited;

        Node(int value) {
            this.value = value;
            this.isVisited = false;
        }
    }

    static ArrayList<Node> nodes = new ArrayList<>();

    public List<Node> findNeighbours(int[][] adjacency_matrix, Node x) {
        int nodeIndex = -1;
        List<Node> neighbours = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {
                nodeIndex = i;
                break;
            }
        }
        if (nodeIndex == -1) return neighbours;
        for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
            if (adjacency_matrix[nodeIndex][j] == 1) neighbours.add(nodes.get(j));
        }
        return neighbours;
    }

    //use recurse
    public void dfs(int[][] adjacency_matrix, Node node) {
        if (node.isVisited) return;
        //visit the node
        System.out.print(node.value + " ");
        node.isVisited = true;
        List<Node> neighbours = findNeighbours(adjacency_matrix, node);
        for (Node neighbour : neighbours) {
            if (neighbour != null && !neighbour.isVisited) dfs(adjacency_matrix, neighbour);
        }
    }

    //iterative dfs by using stack
    public void dfsUsingStack(int[][] adjacency_matrix, Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (!current.isVisited) {
                System.out.print(current.value + " ");
                current.isVisited = true;
            }
            List<Node> neighbours = findNeighbours(adjacency_matrix, current);
            for (Node neighbour : neighbours) {
                if (neighbour != null && !neighbour.isVisited) stack.add(neighbour);
            }
        }
    }

    public static void main(String arg[]) {

        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);
        int[][] adjacency_matrix = {
                {0, 1, 1, 0, 0, 0, 0},  // Node 1: 40
                {0, 0, 0, 1, 0, 0, 0},  // Node 2 :10
                {0, 1, 0, 1, 1, 1, 0},  // Node 3: 20
                {0, 0, 0, 0, 1, 0, 0},  // Node 4: 30
                {0, 0, 0, 0, 0, 0, 1},  // Node 5: 60
                {0, 0, 0, 0, 0, 0, 1},  // Node 6: 50
                {0, 0, 0, 0, 0, 0, 0},  // Node 7: 70
        };

        DfsMatrixExample dfsExample = new DfsMatrixExample();

        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(adjacency_matrix, node40);

        System.out.println();

        clearVisitedFlags();

        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(adjacency_matrix, node40);

    }

    public static void clearVisitedFlags() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).isVisited = false;
        }
    }
}