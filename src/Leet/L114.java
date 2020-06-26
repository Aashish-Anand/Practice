package Leet;

import Leet.GenericDataStructure.Tree;

public class L114 {
    public static void main(String[] args) {
        new L114().run();
    }

    private void run() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right = new Tree(5);
        //root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        root.inOrder(root);
        flatten(root);
        root.right = null;
        Tree temp = root;
        while(temp.left!=null){
            temp.right = temp.left;
            temp.left = null;
            temp = temp.right;
        }
        System.out.println();
        while(root!=null) {
            System.out.print(root.data+ " ");
            root = root.right;
        }


    }

    private void flatten(Tree root) {
        if(root == null){
            return;
        }
        if(root.left!=null) {
            flatten(root.left);
            //root.left.right = root;
        }
        if(root.right!=null){
            Tree temp = root;
            for(;temp.left!=null;temp = temp.left);
            flatten(root.right);
            temp.left = root.right;
            root.right = null;
            //root.right.right = temp;
        }

    }

}
