package Leet;

import Leet.GenericDataStructure.LinkedList;

/**
 * Find the number from the binary linked list
 */
public class L1290 {
    public static void main(String[] args) {
        new L1290().run();
    }

    private void run() {
        LinkedList ll = new LinkedList(1);
        ll.add(ll, new LinkedList(0));
        ll.add(ll, new LinkedList(1));
        ll.add(ll, new LinkedList(0));

        System.out.println(findTheNumber(ll));
    }


    private int findTheNumber(LinkedList head) {
        if(head == null) {
            return 0;
        }

        //System.out.println(head.data);
        head = reverse(head);
        //System.out.println(head.data);
        int pow = 0;

        int number = 0;
        while(head!=null) {
            //System.out.println(Math.pow(2,pow) * head.data);
            number += ((int)Math.pow(2,pow) * head.data);
            pow++;
            head = head.next;
        }
        return number;
    }

    private LinkedList reverse(LinkedList head) {
        LinkedList prev = null;
        LinkedList newNode = head;

        while(head.next!=null) {
            newNode = head.next;
            head.next = prev;
            prev = head;
            head = newNode;
        }
        head.next = prev;

        return head;
    }
}
