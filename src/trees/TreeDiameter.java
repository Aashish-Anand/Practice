package trees;

public class TreeDiameter {
    public static void main(String[] args) {
        new TreeDiameter().run();
    }

    private void run() {
        VerticalLevelOrder v = new VerticalLevelOrder();
        v.root = new TreeNode(1);
        v.root.left = new TreeNode(2);
        v.root.right = new TreeNode(3);
        v.root.left.left = new TreeNode(4);
        v.root.left.right = new TreeNode(5);
        v.root.left.left.left = new TreeNode(8);
        v.root.left.left.left.left = new TreeNode(9);
        v.root.left.left.left.left.left = new TreeNode(10);
        v.root.left.right.left = new TreeNode(11);
        v.root.left.right.left.left = new TreeNode(12);
//        v.root.right.left = new TreeNode(6);
//        v.root.right.right = new TreeNode(7);

        run(v.root);
    }

    private void run(TreeNode root) {
        System.out.println(findDiameter(root));
    }

    private int findDiameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDia = findDiameter(root.left);
        int rightDia = findDiameter(root.right);

        return (Math.max(Math.max(1+height(root.left)+height(root.right),leftDia),rightDia));
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
