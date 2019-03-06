package data.structure.online;

import data.structure.custom.AssignTree;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:37 2019/3/6.
 */
@Setter
@Getter
public class Binarytree {
    private Node root;

    public Binarytree(int data) {
        root = new Node(data);
    }

    public void add(Node parent, Node child, AssignTree.Child orientation) {
        if (Objects.equals(orientation, AssignTree.Child.Left)) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.println(String.format("Node[%s]", root.getKey()));
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(2);
        Node n4 = new Node(5);

        //方案1
//        Binarytree tree = new Binarytree(3);
//        tree.add(tree.root, n1, AssignTree.Child.Left);
//        tree.add(tree.root, n2, AssignTree.Child.Right);
//        tree.add(n2, n3, AssignTree.Child.Left);
//        tree.add(n2, n4, AssignTree.Child.Right);
//        tree.preOrder(tree.root);
        //方案2
        Node root = new Node(3);
        root.setLeft(n1);
        root.setRight(n2);
        n2.setLeft(n3);
        n2.setRight(n4);
        preOrder(root);
    }
}


@Setter
@Getter
class Node {
    private int key;
    private Node left;
    private Node right;

    Node(int key) {
        this.key = key;
    }
}