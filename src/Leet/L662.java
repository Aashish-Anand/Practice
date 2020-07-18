package Leet;

import Leet.GenericDataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * What I have done is, as you know in a complete binary tree there are 2*n number of nodes where n is level
 *
 * Now in laymen what i did is just find what is the position of the each node at each level
 *
 * let have an example at level 2 we have 4 node i.e [30,20,null,10] , position of node are as follows
 * 30: position1
 * 20: position2
 * null: we wont considered
 * 10: position4
 *
 * so max width at this level is position4 - position1 i.e 3
 * this is what i done here;
 */
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
                    // this is to find the first element in a particular level
                    first = e.position;
                }
                else {
                    // this to find the last element in a particular level and also check the
                    // maximum distance between the first node and last node at a level
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
