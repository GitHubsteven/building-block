package data.structure.custom;

import algorithm.ANode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: asaland
 * @date: 2019/2/23
 * @time: 13:40
 * @version: 1.0.0
 * @description: 树的初始化
 **/
@Setter
@Getter
public class ABitree<T extends Comparable> {
    private ANode<T> root;

    public ABitree(ANode<T> root) {
        this.root = root;
    }

    public ABitree(T rootVal) {
        this.root = new ANode<>(rootVal);
    }

    public boolean addNode(T nodeValue) {
        ANode<T> tmpNode = this.root;
        while (tmpNode != null) {

        }
        return true;
    }
}
