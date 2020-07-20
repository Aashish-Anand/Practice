package trees;

public class BurnBinaryTree {
    public static void main(String[] args) {
        new BurnBinaryTree().run();
    }

    private void run() {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(20);
        root.right.left = new Tree(4);
        root.right.right = new Tree(5);
        root.right.left.left = new Tree(6);
        root.right.left.right = new Tree(7);
        root.right.left.left.left = new Tree(100);
        root.right.left.left.left.left = new Tree(200);
        root.right.left.left.left.left.left = new Tree(300);
        root.right.left.left.left.left.left.left = new Tree(400);
        root.right.left.left.left.left.left.left.left = new Tree(500);

        root.right.right.left = new Tree(8);
        root.right.right.right = new Tree(9);
        root.right.right.left.left = new Tree(10);

        int firstNodeToBurn = 300;

        findTimeToBurnTree(root, firstNodeToBurn);
        System.out.println(timeToBurn);
    }

    int timeToBurn = 0;
    private int findTimeToBurnTree(Tree root, int firsNodeToBurn) {
        if(root == null){
            return -1;
        }

        if(root.data == firsNodeToBurn){
            letBurnAllTheChildOfIt(root, 0);
            return 1;
        }

        int distance = findTimeToBurnTree(root.left, firsNodeToBurn);

        if(distance != -1){
            if(distance>timeToBurn){
                timeToBurn = distance;
            }
            letBurnAllTheChildOfIt(root.right, distance+1);
            return distance+1;
        }

        int distanceRight = findTimeToBurnTree(root.right, firsNodeToBurn);
        if(distanceRight != -1){
            if(distanceRight > timeToBurn){
                timeToBurn = distanceRight;
            }
            letBurnAllTheChildOfIt(root.left, distanceRight+1);
            return distanceRight+1;
        }

        return -1;
    }

    private void letBurnAllTheChildOfIt(Tree root, int k) {
        if(root == null){
            return;
        }
        if(k > timeToBurn){
            timeToBurn = k;
        }
        letBurnAllTheChildOfIt(root.left, k+1);
        letBurnAllTheChildOfIt(root.right, k+1);
    }
}
