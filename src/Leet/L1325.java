package Leet;

public class L1325 {
    public static void main(String[] args) {
        new L1325().run();
    }

    private void run() {

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
//        root.left.left = new Tree(4);
//        root.left.right = new Tree(5);
        root.right.left = new Tree(3);
        root.right.right = new Tree(3);

        Tree temp = new Tree();
        temp.inOrder(removeLeafNode(root,3));
    }

    private Tree removeLeafNode(Tree root, int target) {
        if(root == null) {
            return null;
        }

        if(root.left== null && root.right == null && root.data ==  target) {
            return null;
        }

        root.left = removeLeafNode(root.left, target);
        root.right = removeLeafNode(root.right, target);

        if(root.left == null && root.right == null && root.data == target) {
            return null;
        }
        return root;
    }
}
