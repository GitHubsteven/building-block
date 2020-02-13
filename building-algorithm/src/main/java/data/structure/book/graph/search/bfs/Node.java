package data.structure.book.graph.search.bfs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @Authoer: asa.x
 * @Date: 2020/2/12
 * @Descrition:
 */
@Setter
@Getter
public class Node<T> {
    private T value;
    private Set<Node<T>> neighbors;

    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public void connect(Node<T> node) {
        if (node == null || node == this)
            throw new IllegalArgumentException("can't connect to null or itself");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }
}
