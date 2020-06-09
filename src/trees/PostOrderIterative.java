package trees;

import java.util.Stack;

public class PostOrderIterative {
    public static void main(String[] args) {
        new PostOrderIterative().run();
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

        postOrder(v.root);
    }

    private void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> ansStack = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            ansStack.push(temp);

            if(temp.left!=null){
                stack1.push(temp.left);
            }
            if(temp.right!=null) {
                stack1.push(temp.right);
            }
        }

        while(!ansStack.isEmpty()) {
            System.out.print(ansStack.pop().data+" ");
        }
    }
}
