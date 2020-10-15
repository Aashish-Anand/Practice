package PaajiTest;

import java.util.HashMap;

public class LruCachePaaji {
    public static void main(String[] args) {
        new LruCachePaaji().run();
    }

    private class LinkedList {
        int data;
        LinkedList next;
        LinkedList prev ;

        public LinkedList(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    LinkedList head;
    LinkedList tail;
    HashMap<Integer, LinkedList> map = new HashMap<>(3);


    private void insert(int num) {
        /*
        1. When no data is present in cache
         */
        if(tail == null && head == null) {
            LinkedList newNode = new LinkedList(num);
            tail = newNode;
            head = newNode;
            map.put(num, newNode);
        }

        /*
        2. if some data is present
            a. if data we are inserting is already there in the map then we have to resuffle
            b. if cache is full , them we have to remove most old data
            c. else we simply add the data
         */
        else {
            if (map.containsKey(num)) {
                // move the data to first place
                moveNodeToFirst(num);
            } else if (!map.containsKey(num) && map.size() == 3) {
                addNewNode(num);
            } else if (!map.containsKey(num)) {

                LinkedList newNode = new LinkedList(num);

                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                map.put(num,newNode);
            }
        }
    }

    private void moveNodeToFirst(int num) {
        LinkedList node = map.get(num);

        //case 1: if current node present in somewhere between
        if(node.next != null && node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        // case 2 : if node is present at last we have to move it to first
        else if(node.next== null) {
            node.prev.next = null;
            tail = node.prev;

            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void addNewNode(int num) {

        LinkedList toBeRemovedNode = tail;
        map.remove(toBeRemovedNode);
        tail = tail.prev;
        tail.next = null;
        toBeRemovedNode.prev = null;
        toBeRemovedNode = null;

        LinkedList newNode = new LinkedList(num);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    private void print(int num) {
        LinkedList node = head;
        System.out.println();
        System.out.print("Inserting: "+num+" -> ");
        while(node!=null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    private void run() {

        insert(1);
        print(1);
        insert(2);
        print(2);
        insert(3);
        print(3);
        insert(4);
        print(4);
        insert(3);
        print(3);
        insert(2);
        print(2);
    }
}
