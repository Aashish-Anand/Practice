package trees;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.LinkedList;
import java.util.List;

public class printAllPathWithGivenProduct {
    public static void main(String[] args) {
        new printAllPathWithGivenProduct().run();
    }

    private void run() {
        Tree t = new Tree(1);
        t.left = new Tree(2);
        t.right = new Tree(3);
        t.left.left = new Tree(3);
        t.left.right = new Tree(15);
        t.right.left = new Tree(10);
        t.right.right = new Tree(2);
        t.right.right.right = new Tree(5);

        findAllPaths(t, 30);

        listOfList.forEach(a -> {
            a.forEach(num -> System.out.print(num + " "));
            System.out.println();
        });

//        for(List<Integer> list : listOfList){
//            for(Integer element : list) {
//                System.out.print(element+" ");
//            }
//            System.out.println();
//        }
    }

    List<List<Integer>> listOfList = new LinkedList<>();

    private void findAllPaths(Tree root, int product) {
        if (root == null || root.data > product) {
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(root.data);
        int currentProduct = root.data;

        findPath(root.left, list, currentProduct, product);
        findPath(root.right, list, currentProduct, product);
    }

    private void findPath(Tree node, LinkedList<Integer> list, int currentProduct, int product) {
        if (node == null) {
            return;
        }
        if (node.data * currentProduct < product) {
            list.add(node.data);
            findPath(node.left, list, currentProduct * node.data, product);
            findPath(node.right, list, currentProduct * node.data, product);
            list.removeLast();
        } else if (node.data * currentProduct == product) {
            list.add(node.data);
            LinkedList<Integer> newList = new LinkedList<>(list);
            listOfList.add(newList);
            list.removeLast();
        }
    }
}
