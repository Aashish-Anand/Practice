package Leet;

import Leet.GenericDataStructure.Tree;
import sun.plugin2.message.JVMStartedMessage;

import javax.swing.tree.TreeNode;

public class L297 {
    public static void main(String[] args) {
        new L297().run();
    }

    private void run() {
        Tree root = new Tree(1);
        root.left = new Tree(9);
        root.left.left = new Tree(2);
        root.left.right = new Tree(8);
        root.right = new Tree(10);
//        root.right.left = new Tree(6);
//        root.right.right = new Tree(7);

        String serialized = serialize(root);
        System.out.println(serialized);

        root = deserialize(serialized);
        root.inOrder(root);
    }

    private String serialize(Tree node){
        serializeUtil(node);
        return ans.toString();

    }

    StringBuilder ans = new StringBuilder();
    private void serializeUtil(Tree root) {
        if(root==null){
            ans.append("n");
            ans.append(",");
            return;
        }
        ans.append(String.valueOf(root.data));
        ans.append(",");
        serialize(root.left);
        serialize(root.right);
    }

    private Tree deserialize(String s) {
        Tree newRoot = new Tree();
        String str[] = s.split(",");
        newRoot = deserializeUtil(str, newRoot);
        return newRoot;
    }

    int i = 0;
    private Tree deserializeUtil(String str[], Tree newRoot) {
        if(str[i].equals("n") ){
            i+=1;
            return null;
        }
        newRoot = new Tree(Integer.parseInt(str[i]));
        i+= 1;
        newRoot.left = deserializeUtil(str, newRoot);
        newRoot.right = deserializeUtil(str,  newRoot);
        return newRoot;
    }
}
