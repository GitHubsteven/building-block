package data.structure.book.graph.search.dfs;

import java.util.List;
import java.util.Stack;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://java2blog.com/depth-first-search-in-java/
 * @Author asa.x
 * @Date: Created at 14:00 2020/3/2.
 */
public class DfsInJavaExp1 {

    private void dfsUsingStack(DfsNode start) {
        Stack<DfsNode> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            DfsNode top = stack.pop();
            if (!top.isVisited()) {
                System.out.print(top.getValue() + " ");
                top.setVisited(true);
            }
            for (DfsNode neighbour : top.getNeighbours()) {
                if (neighbour != null && !neighbour.isVisited())
                    stack.add(neighbour);
            }
        }
    }

    private void dfs(DfsNode start) {
        System.out.print(start.getValue() + " ");
        start.setVisited(true);
        List<DfsNode> neighbours = start.getNeighbours();
        for (DfsNode neighbour : neighbours) {
            if (neighbour != null && !neighbour.isVisited()) dfs(neighbour);
        }
    }


    public static void main(String[] args) {
        DfsInJavaExp1 dfsExample = new DfsInJavaExp1();

        DfsNode node40 = new DfsNode(40);
        DfsNode node20 = new DfsNode(20);
        DfsNode node10 = new DfsNode(10);
        DfsNode node30 = new DfsNode(30);
        DfsNode node60 = new DfsNode(60);
        DfsNode node50 = new DfsNode(50);
        DfsNode node70 = new DfsNode(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(node40);

        System.out.println();

        // Resetting the visited flag for nodes
        node40.setVisited(false);
        node10.setVisited(false);
        node20.setVisited(false);
        node30.setVisited(false);
        node60.setVisited(false);
        node50.setVisited(false);
        node70.setVisited(false);

        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(node40);
    }
}