package Leet;

import Leet.GenericDataStructure.Tree;

public class L1038 {
    public static void main(String[] args) {
        new L1038().run();
    }

    private void run() {
        Tree root = new Tree(11);
        root.left = new Tree(2);
        root.right = new Tree(29);
        root.left.left = new Tree(1);
        root.left.right = new Tree(7);
        root.right.left = new Tree(15);
        root.right.right = new Tree(40);
        root.right.right.left = new Tree(35);

        root.inOrder(root);

        letsChangeThisTree(root);

        System.out.println();
        root.inOrder(root);
    }

    int sum = 0;
    boolean firstTime = false;
    private void letsChangeThisTree(Tree root) {
        if(root == null){
            return;
        }

        letsChangeThisTree(root.right);

        int tempSum = sum;
        sum += root.data;
        root.data = tempSum;
        if(!firstTime){
            root.data = sum;
            firstTime = true;
        }
        letsChangeThisTree(root.left);
    }
}
