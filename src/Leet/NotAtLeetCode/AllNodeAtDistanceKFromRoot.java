package Leet.NotAtLeetCode;

import Leet.GenericDataStructure.Tree;

public class AllNodeAtDistanceKFromRoot {
    public static void main(String[] args) {
        new AllNodeAtDistanceKFromRoot().run();
    }

    private void run() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        int dist = 2;

        findAllNode(root, dist);
    }
    private void findAllNode(Tree root, int dist) {

        if(root==null){
            return;
        }
        if(dist == 0){
            System.out.print(root.data+" ");
        }
        else{
            findAllNode(root.left, dist-1);
            findAllNode(root.right,dist-1);
        }
    }
}
