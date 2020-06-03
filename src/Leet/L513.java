package Leet;

import Leet.GenericDataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class L513 {
    public static void main(String[] args) {
        new L513().run();
    }

    private void run() {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        System.out.println(findBottomLeftValue(root));
    }

    private int findBottomLeftValue(Tree root) {
        if(root.left==null && root.right==null) {
            return root.data;
        }

        Queue<Tree> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int first = -1;
        while (q.size()>0) {
            Tree node = q.poll();
            if(node == null){
                if(q.size()>0) {
                    first = q.peek().data;
                    q.add(null);
                }
            }
            else{
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
        }

        return first;

    }
}
