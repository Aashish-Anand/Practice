package trees;


import java.util.LinkedList;

public class MirrorIterative {

    Tree root;

    public static void main(String[] args) {
        new MirrorIterative().run();
    }

    private void inOrder(Tree temp) {
        if(temp == null) {
            return;
        }
        inOrder(temp.left);
        System.out.print(temp.data+" ");
        inOrder(temp.right);
    }

    private void mirror(Tree root) {
        LinkedList<Tree> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Tree temp = q.poll();
            if(temp == null){
                if(q.size()==0){
                    break;
                }
                q.add(null);

            }
            else {
                Tree tempLeft = temp.left;
                temp.left = temp.right;
                temp.right = tempLeft;
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }
    private void run() {
        root = new Tree(1);
        //root.left = new Tree(2);
        root.right = new Tree(2);
        //root.left.left = new Tree(4);
        //root.left.right = new Tree(5);
        root.right.left = new Tree(3);
        //root.right.right = new Tree(7);
        root.right.left.right = new Tree(4);

        inOrder(root);

        mirror(root);
        System.out.println();
        inOrder(root);
    }
}
