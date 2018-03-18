package composite.indiv.example;

import java.util.Enumeration;

public class Tree {

    TreeNode root ;

    public Tree(String name){
        root = new TreeNode(name);
    }
    public static void main(String[] args) {
        Tree tree = new Tree("root");
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");

        tree.root.add(nodeA);
        tree.root.add(nodeB);

        Enumeration<TreeNode> children = tree.root.getChildren();
        while(children.hasMoreElements()){
            System.out.println(children.nextElement());
        }
    }
}
