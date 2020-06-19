package Leet;

import Leet.GenericDataStructure.LinkedList;

import javax.sound.sampled.Line;

/**
 * Reverse the linked_list_2 from m to n position
 */
public class L92 {
    public static void main(String[] args) {
        new L92().run();
    }

    private void run() {
        LinkedList ll = new LinkedList(1);
        ll.add(ll, new LinkedList(2));
        ll.add(ll, new LinkedList(3));
        ll.add(ll, new LinkedList(4));
        ll.add(ll, new LinkedList(5));
        ll.add(ll, new LinkedList(6));
        ll.add(ll, new LinkedList(7));

        ll = reverseAdvanced(ll, 5, 7);

        ll.printList(ll);

    }
    private LinkedList reverseAdvanced(LinkedList head, int m , int n) {

        int i= 1;

        LinkedList temp = head;
        LinkedList prev = null;
        while(i<m) {
            prev = temp;
            temp = temp.next;
            i++;
        }

        LinkedList newTemp = head;
        i = 1;
        while(i<n) {
            newTemp = newTemp.next;
            i++;
        }
        newTemp = newTemp.next;

        //System.out.println(newTemp.data);

        if(prev == null) {
            prev = reverse(temp, n-m);
            head = prev;
        }
        else {
            prev.next = reverse(temp, n-m);
        }
        while(prev.next!= null) {
            prev = prev.next;
        }
        prev.next = newTemp;
        return head;
    }

    private LinkedList reverse(LinkedList head , int n) {
        LinkedList prev = null;
        LinkedList newNode = head;

        int i = 0;
        while(i <n) {
            newNode = head.next;
            head.next = prev;
            prev = head;
            head = newNode;
            i++;
        }
        head.next = prev;
        return head;
    }
}
