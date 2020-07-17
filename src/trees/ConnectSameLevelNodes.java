package trees;

public class ConnectSameLevelNodes {
    public static void main(String[] args) {
        new ConnectSameLevelNodes().run();
    }

    class myTree{
        int data;
        myTree left;
        myTree right;
        myTree nextSibling;
        myTree(int data) {
            this.data = data;
        }
    }
    private void run() {
        myTree t = new myTree(1);
        t.left = new myTree(2);
        t.right = new myTree(3);
        t.left.left = new myTree(4);
        t.left.right = new myTree(5);
        t.right.left = new myTree(6);
        t.right.right = new myTree(7);

        letsConnect(t);
        printIt(t);
    }

    private void printIt(myTree root) {
        if(root == null){
            return;
        }
        System.out.print(root.data);
        if(root.nextSibling!=null) {
            System.out.print("  "+root.nextSibling.data);
        }
        else{
            System.out.print("  null");
        }
        System.out.println();
        printIt(root.left);
        printIt(root.right);
    }

    private void letsConnect(myTree root) {
        if(root==null){
            return;
        }
        root.nextSibling = null;

        connectChild(root);
    }

    private void connectChild(myTree root){
        if(root == null){
            return;
        }

        if(root.left!=null){
            if(root.right!=null){
                root.left.nextSibling = root.right;
            }
            else{
                root.left.nextSibling = findSibling(root.nextSibling);
            }
        }
        if(root.right != null){
            root.right.nextSibling = findSibling(root.nextSibling);
        }
        connectChild(root.left);
        connectChild(root.right);
    }
    private myTree findSibling(myTree root){
        if(root == null){
            return null;
        }
        if(root.left !=null) {
            return root.left;
        }
        if(root.right!=null) {
            return root.right;
        }
        return findSibling(root.nextSibling);
    }
}
