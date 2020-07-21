package Leet;

import Leet.GenericDataStructure.Tree;

public class L230 {
    public static void main(String[] args) {
        new L230().run();
    }
    private void run() {
        Tree root = new Tree(4);
        root.left = new Tree(2);
        root.right = new Tree(6);
        root.left.left = new Tree(1);
        //root.left.right = new Tree(3);
        root.right.left = new Tree(5);
        root.right.right = new Tree(7);

        int k = 3;

        System.out.println(kthSmallest(root, k));
    }

    int num = 0;
    int count = 0;
    private int kthSmallest(Tree root, int k) {
        if(root == null){
            return 0;
        }

        solveUsingInOrder(root, k);
        return num;
    }

    private int solveUsingInOrder(Tree root, int k) {
        if(root==null){
            return -1;
        }

        int val = solveUsingInOrder(root.left, k);
        if(val == 1){
            return val;
        }
        count+=1;
        if(count == k){
            num = root.data;
            return 1;
        }

        int val1 = solveUsingInOrder(root.right, k);
        if(val1 == 1){
            return val1;
        }
        return -1;
    }
}
