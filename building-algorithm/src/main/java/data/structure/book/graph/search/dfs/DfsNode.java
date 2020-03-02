package data.structure.book.graph.search.dfs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 14:01 2020/3/2.
 */
@Setter
@Getter
public class DfsNode {
    private List<DfsNode> neighbours;
    private boolean visited;
    private int value;

    public DfsNode(int value) {
        this.value = value;
        this.visited = false;
        this.neighbours = new ArrayList<>();
    }

    public void addneighbours(DfsNode neighbour) {
        this.neighbours.add(neighbour);
    }

}