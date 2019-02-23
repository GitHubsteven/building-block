package algorithm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: asaland
 * @date: 2019/2/23
 * @time: 13:36
 * @version: 1.0.0
 * @description:
 **/
@Setter
@Getter
public class ANode<T> {
    private T value;
    private ANode<T> leftChild;
    private ANode<T> rightChild;

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public ANode(T value) {
        this.value = value;
    }

    public ANode() {
    }

    public T getValue() {
        return value;
    }

    public ANode setValue(T value) {
        this.value = value;
        return this;
    }

    public ANode<T> getLeftChild() {
        return leftChild;
    }

    public ANode setLeftChild(ANode<T> leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public ANode<T> getRightChild() {
        return rightChild;
    }

    public ANode setRightChild(ANode<T> rightChild) {
        this.rightChild = rightChild;
        return this;
    }
}
