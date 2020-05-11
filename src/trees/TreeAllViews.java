package trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class myTree {
    int data;
    myTree left;
    myTree right;

    myTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeAllViews {
    public static void main(String[] args) {
        new TreeAllViews().run();
    }

    myTree t;

    private void run() {

        t = new myTree(1);
        t.left = new myTree(2);
        t.right = new myTree(3);
        t.left.left = new myTree(4);
        t.left.right = new myTree(5);
        t.left.left.left = new myTree(9);
        t.left.left.right = new myTree(10);

        t.right.right = new myTree(6);
        t.right.right.left = new myTree(7);
        t.right.right.right = new myTree(8);

        System.out.print("Level Order : ");
        levelOrder(t);
        System.out.print("Left View : ");
        leftView(t);
        System.out.print("Right View : ");
        rightView(t);
        System.out.print("Top View : ");
        topView(t);
        System.out.print("Bottom View : ");
        bottomView(t);
    }

    private void levelOrder(myTree root) {

        if (root == null) {
            return;
        }
        LinkedList<myTree> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            myTree temp = queue.poll();
            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            } else if (queue.size() > 0) {
                queue.add(null);
            }
        }
        System.out.println();
    }

    private void leftView(myTree root) {
        if (root == null) {
            return;
        }
        LinkedList<myTree> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        System.out.print(root.data + " ");

        while (!queue.isEmpty()) {
            myTree temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            } else if (queue.size() > 0) {
                queue.add(null);
                if (!queue.isEmpty()) {
                    System.out.print(queue.peek().data + " ");
                }
            }
        }
        System.out.println();
    }

    private void rightView(myTree root) {
        if (root == null) {
            return;
        }
        LinkedList<myTree> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            myTree temp = queue.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (queue.peek() == null) {
                    System.out.print(temp.data + " ");
                }
            } else if (queue.size() > 0) {
                queue.add(null);
            }
        }
        System.out.println();
    }

    class Node {
        myTree treeNode;
        int level;

        Node(myTree node, int level) {
            this.treeNode = node;
            this.level = level;
        }
    }

    private void topView(myTree t) {

        TreeMap<Integer, myTree> map = new TreeMap<>(Collections.reverseOrder());

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(t, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            myTree temp = node.treeNode;
            int level = node.level;

            if (!map.containsKey(level)) {
                map.put(level, temp);
            }
            if (temp.left != null) {
                queue.add(new Node(temp.left, level + 1));
            }
            if (temp.right != null) {
                queue.add(new Node(temp.right, level - 1));
            }

        }

        for (Map.Entry<Integer, myTree> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
        System.out.println();
    }

    private void bottomView(myTree t) {

        TreeMap<Integer, myTree> map = new TreeMap<>(Collections.reverseOrder());

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(t, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            myTree temp = node.treeNode;
            int level = node.level;

            map.put(level, temp);

            if (temp.left != null) {
                queue.add(new Node(temp.left, level + 1));
            }
            if (temp.right != null) {
                queue.add(new Node(temp.right, level - 1));
            }

        }

        for (Map.Entry<Integer, myTree> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
        System.out.println();
    }
}
