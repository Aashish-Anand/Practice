package trees;


import java.util.Stack;

public class InOrderIterative {
    public static void main(String[] args) {
        new InOrderIterative().run();
    }

    private void run() {
        VerticalLevelOrder v = new VerticalLevelOrder();
        v.root = new TreeNode(1);
        v.root.left = new TreeNode(2);
        v.root.right = new TreeNode(3);
        v.root.left.left = new TreeNode(4);
        v.root.left.right = new TreeNode(5);
        v.root.right.left = new TreeNode(6);
        v.root.right.right = new TreeNode(7);

        printInOrder2(v.root);
    }

    private void printInOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();


        while (!stack.isEmpty() || root != null) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");

                root = root.right;
            }
        }
    }

    private void printInOrder2(TreeNode root) {

        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            if(stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            System.out.print(root.data+" ");
            root = root.right;
        }
    }

}
