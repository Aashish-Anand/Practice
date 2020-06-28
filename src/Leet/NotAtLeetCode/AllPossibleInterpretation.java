package Leet.NotAtLeetCode;

import java.util.Arrays;

class StringTree {
    String data;
    StringTree left;
    StringTree right;

    StringTree(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class AllPossibleInterpretation {
    public static void main(String[] args) {
        new AllPossibleInterpretation().run();
    }

    private void run() {
        int arr[] = {9, 1, 8};
        int n = arr.length;
        StringTree root = findAll(0,"",arr);

        printAllTheLeaf(root);
    }

    String character[] = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"
            , "Q", "R", "S", "T", "U", "V", "X", "Y", "Z"};

    private StringTree findAll(int number, String s, int arr[]) {
        if(number > 26){
            return null;
        }

        String newString = s+character[number];
        StringTree root = new StringTree(newString);

        if(arr.length > 0){
            // here we are recursively calling the left and right tree
            // left tree will have only 1 element selected
            // right subtree will have 2 element selected

            int newArr[] = Arrays.copyOfRange(arr, 1, arr.length);
            int num = arr[0];
            root.left = findAll(num, newString, newArr);

            if(arr.length > 1){
                num = arr[0]*10 + arr[1];

                newArr = Arrays.copyOfRange(arr, 2, arr.length);
                root.right = findAll(num, newString, newArr);
            }
        }
        return root;
    }

    private void printAllTheLeaf(StringTree root) {
        if(root==null){
            return;
        }
        if(root.left == null && root.right==null){
            System.out.println(root.data);
            return;
        }
        printAllTheLeaf(root.left);
        printAllTheLeaf(root.right);
    }
}
