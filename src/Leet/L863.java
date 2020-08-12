package Leet;

import Leet.GenericDataStructure.Tree;

import java.util.LinkedList;
import java.util.List;

public class L863 {
    public static void main(String[] args) {
        new L863().run();
    }
    private void run() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.left.right.left = new Tree(6);
        root.left.right.right = new Tree(7);

        Tree target = root.left.right;
        int k = 2;
        distanceK(root, target, 2).forEach(a-> System.out.print(a+" "));
    }

    List<Integer> ans = new LinkedList<>();
    private List<Integer>  distanceK(Tree root, Tree target, int k) {
        /*
        Here we have 2 types of node to cover i.e ;
        1. all the nodes that are present in the subtree of the target Node;
        2. All the nodes that are parent or ancestor of target node and at distance k.

        for step 1 we can easily do that by subtracting the distance by 1 for left and right child
        in recursive call. and when distance is 0 we print the node

        for step 2 we have to check what is the distance of ancestor
            a. if distance between ancestor and target node is 0 then print it
            b. if distance is greater than 0 then we have to traverse the adjacent subtree of ancestor also;
         */

        distanceKUtil(root, target, k);
        return ans;

    }

    private int distanceKUtil(Tree root, Tree target, int k){
        if(root == null){
            //corner case : if tree is null
            return -1;
        }

        if(root == target){
            // this is our first case
            findNodeAtDistanceKFromRoot(root,k);
            return 0;
        }


        // to check if node is present in left subtree
        int distanceLeft = distanceKUtil(root.left, target, k);
        // from here we have second case
        if(distanceLeft != -1){
            if(distanceLeft+1 == k) {
                // this is to check the ancestor as ancestor is at distance 1 from the child and we keep
                // on adding as the recursive call unwraps
                ans.add(root.data);
            }
            else{
                // now if ancestor is not at the same distance then we have to check the right subtree of the
                // ancestor to find all the element at dist k - dist - 2 // -2 is because left child to
                // parent is 1 and parent to 1st right child is one
                findNodeAtDistanceKFromRoot(root.right, k-distanceLeft-2);
            }
            return distanceLeft+1;
        }

        // to check if node in not present in left subtree so we need to check the right sub tree
        int distanceRight = distanceKUtil(root.right, target, k);

        if(distanceRight != -1) {
            if(distanceRight+1 == k){
                ans.add(root.data);
            }
            else{
                findNodeAtDistanceKFromRoot(root.left, k - distanceRight-2);
            }
            return distanceRight+1;
        }
        return -1;
    }

    // this is the 1st case
    private void findNodeAtDistanceKFromRoot(Tree root, int k){

        if(root == null || k<0){
            return;
        }
        if(k == 0){
            ans.add(root.data);
            return;
        }

        findNodeAtDistanceKFromRoot(root.left, k-1);
        findNodeAtDistanceKFromRoot(root.right, k-1);
    }
}
