package Leet;

import Leet.GenericDataStructure.Tree;
import sun.java2d.loops.GraphicsPrimitiveProxy;

public class BinaryTreeToDLL {
    public static void main(String[] args) {
        new BinaryTreeToDLL().run();
    }

    private void run() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        // Both ways are working

//        letsConvertWithoutUsingInOrder(root);
//        while(root.left!=null){
//            root = root.left;
//        }

//        while(root!=null){
//            System.out.print(root.data+" ");
//            root = root.right;
//        }

        letsConvertUsingInOrder(root);
        while(head != null){
            System.out.print(head.data+" ");
            head = head.right;
        }
    }

    private Tree letsConvertWithoutUsingInOrder(Tree root){
        if(root == null){
            return root;
        }

        if(root.left!=null){
            Tree left = letsConvertWithoutUsingInOrder(root.left);
            for(;left.right!=null;left = left.right);
            left.right = root;
            root.left = left;
        }

        if(root.right!=null){
            Tree right = letsConvertWithoutUsingInOrder(root.right);
            for(;right.left!=null;right = right.left);
            right.left = root;
            root.right = right;
        }
        return root;
    }

    Tree prev = null;
    Tree head = null;  //  head of our linked list

    private void letsConvertUsingInOrder(Tree root) {
        if(root==null){
            return;
        }

        letsConvertUsingInOrder(root.left);

        if(prev == null){
            head = root;
        }
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        letsConvertUsingInOrder(root.right);

    }
}
