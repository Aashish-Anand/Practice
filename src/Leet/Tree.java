package Leet;

public class Tree {
    int data;
    Tree left, right;

    Tree() {

    }
    Tree(int data) {
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
