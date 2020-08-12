package Leet;

import Leet.GenericDataStructure.Tree;

public class L951 {
    public static void main(String[] args) {
        new L951().run();
    }

    private void run() {
        Tree t1 = new Tree(1);
        t1.left = new Tree(2);
        t1.right = new Tree(3);
        t1.left.left = new Tree(4);
        t1.left.right = new Tree(5);
        t1.left.right.left = new Tree(7);
        t1.left.right.right = new Tree(8);
        t1.right.left = new Tree(6);


        Tree t2 = new Tree(1);
        t2.left = new Tree(3);
        t2.left.right = new Tree(6);
        t2.right = new Tree(2);
        t2.right.left = new Tree(4);
        t2.right.right = new Tree(5);
        t2.right.right.left = new Tree(8);
        t2.right.right.right = new Tree(7);
        //t2.right.right.right.left = new Tree(10);


        System.out.println(flipEquiv(t1, t2));
    }

    public boolean flipEquiv(Tree root1, Tree root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }

        boolean symmetric = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean aSymmetric = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return true && (symmetric||aSymmetric);

    }
}
