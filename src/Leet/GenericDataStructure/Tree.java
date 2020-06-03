package Leet.GenericDataStructure;

public class Tree {
    public int data;
    public Tree left, right;

    public Tree() {

    }
    public Tree(int data) {
        this.data = data;
        left = right = null;
    }

    public void inOrder(Tree root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }
}
