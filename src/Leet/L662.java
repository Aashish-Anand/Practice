package Leet;

import Leet.GenericDataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class L662 {
    public static void main(String[] args) {
        new L662().run();
    }

    private void run() {
        Tree tree = new Tree(1);
        tree.left = new Tree(3);
        tree.right = new Tree(2);
        tree.left.left = new Tree(5);
        tree.left.right = new Tree(3);
        tree.right.right = new Tree(9);

        System.out.println(widthOfBinaryTree(tree));
    }

    class element {
        Tree node;
        int position;
        element(Tree node, int position) {
            this.node = node;
            this.position = position;
        }
    }
    private int widthOfBinaryTree(Tree root) {
        if(root == null){
            return 0;
        }
        Queue<element> queue = new LinkedList<>();
        queue.add(new element(root, 1));
        queue.add(new element(new Tree(-10000), -100));
        int max = 1;
        int first = -1;
        int last = -1;

        while(!queue.isEmpty()){
            element e = queue.poll();
            if(e.node.data == -10000){
                if(queue.size()==0){
                    break;
                }
                queue.add(new element(new Tree(-10000), -100));
                first = -1;
                last = -1;
            }
            else {
                if(first == -1) {
                    first = e.position;
                }
                else {
                    last = e.position;
                    max = Math.max(max, last-first+1);
                }
                if(e.node.left!=null){
                    queue.add(new element(e.node.left, (2*e.position)-1));
                }
                if(e.node.right!=null){
                    queue.add(new element(e.node.right, (2*e.position)));
                }
            }
        }
        return max;
    }
}
