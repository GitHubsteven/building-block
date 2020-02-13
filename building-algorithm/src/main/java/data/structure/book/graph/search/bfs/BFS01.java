package data.structure.book.graph.search.bfs;

import java.util.*;

/**
 * @Authoer: asa.x
 * @Date: 2020/2/12
 * @Descrition: url: https://www.baeldung.com/java-breadth-first-search
 */
public class BFS01 {
    public static <T> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);
        Set<Node<T>> alreadyVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            System.out.println("visiting node: " + current.getValue());
            if (current.getValue().equals(value)) return Optional.of(current);
            alreadyVisited.add(current);
            current.getNeighbors().removeAll(alreadyVisited);
            queue.addAll(current.getNeighbors());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        Node<Integer> secondNeighbor = new Node<>(4);

        start.connect(secondNeighbor);

        Optional<Node<Integer>> search = search(4, firstNeighborNeighbor);
        if (search.isPresent()) {
            Node<Integer> target = search.get();
            System.out.println(target);
        }
    }
}
