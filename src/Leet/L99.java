package Leet;

import Leet.GenericDataStructure.Tree;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class L99 {
    public static void main(String[] args) {
        new L99().run();
    }

    private void run() {
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.left.left = new Tree(-2147483648);
        root.left.right = new Tree(2);
        root.right = new Tree(9);
//        root.right = new Tree(2);
//        root.right.left = new Tree(5);
//        root.right.right = new Tree(7);

        //recoverTree(root);
        recoverTree2(root);
        System.out.println();
       // root.inOrder(root);
    }

    private void recoverTree(Tree root) {
        // 1. first we find the inorder traversal of tree and store that in our list
        //    after that we sort that list to find out which 2 element are diffrent
        // 2. then we find the levelorder traversal and here we will interchange the value of 2 diff pointers
        inorder(root);

        recoverTreeUtil(root);

        root.inOrder(root);
    }

    List<Integer> arr = new LinkedList<>();

    private void inorder(Tree root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        arr.add(root.data);
        inorder(root.right);
    }

    List<Tree> levelOrder = new LinkedList<>();

    private void recoverTreeUtil(Tree root) {
        //arr.forEach(a-> System.out.print(a+" "));
        List<Integer> sorted = new LinkedList<>(arr);
        Collections.sort(sorted);

        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            if (element1 == Integer.MIN_VALUE && arr.get(i) != sorted.get(i)) {
                element1 = arr.get(i);
            } else if (arr.get(i) != sorted.get(i)) {
                element2 = arr.get(i);
            }
        }
        if(element1==Integer.MIN_VALUE){
            return;
        }

        System.out.println(element1 + " " + element2);

        levelOrderTraversal(root);

        int pos1 = -1;
        int pos2 = -1;

        for(int i = 0;i<levelOrder.size();i++) {
            if(levelOrder.get(i)!=null) {
                if (levelOrder.get(i).data == element1) {
                    pos1 = i;
                } else if (levelOrder.get(i).data == element2) {
                    pos2 = i;
                }

                if (pos1 != -1 && pos2 != -1) {
                    break;
                }
            }
        }

        Tree node1 = levelOrder.get(pos1);
        Tree node2 = levelOrder.get(pos2);
//        Tree parent1 = levelOrder.get(pos1%2==0 ? ((pos1-2)/2):((pos1-1)/2));
//        Tree parent2 = levelOrder.get(pos2%2==0 ? ((pos2-2)/2):((pos2-1)/2));
//
//        if(pos1%2 == 0){
//
//        }
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;

    }

    private void levelOrderTraversal(Tree root) {
        if (root == null) {
            return;
        }

        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Tree node = q.poll();
            levelOrder.add(node);

            if(node!=null) {
                q.add(node.left);
            }

            if(node!=null) {
                q.add(node.right);
            }
        }

        levelOrder.stream().forEach(a -> {
            if(a==null){
                System.out.print("null ");
            }
            else{
                System.out.print(a.data+" ");
            }
        });
    }


    /*
    This is the second solution that i have
    there is no need of level order traversal
     */
    List<Tree> arrtree = new LinkedList<>();
    private void recoverTree2(Tree root) {
        inorder2(root);

        List<Tree> newList = new LinkedList<>(arrtree);

        Collections.sort(newList, (a,b)->Integer.compare(a.data,b.data));

        System.out.println("New list ");
        newList.forEach(a -> System.out.print(a.data+" "));

        Tree first=null;
        Tree second=null;
        for(int i = 0;i<arrtree.size();i++) {
            if(first==null && arrtree.get(i).data!=newList.get(i).data){
                first = arrtree.get(i);
            }
            else if(arrtree.get(i).data!=newList.get(i).data){
                second = arrtree.get(i);
            }
        }

        int temp = first.data;
        first.data = second.data;
        second.data = temp;

    }
    private void inorder2(Tree root){
        if (root == null) {
            return;
        }
        inorder2(root.left);
        arrtree.add(root);
        inorder2(root.right);
    }
}
