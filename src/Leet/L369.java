package Leet;

import Leet.GenericDataStructure.LinkedList;

import javax.sound.sampled.Line;

public class L369 {
    public static void main(String[] args) {
        new L369().run();
    }

    private void run() {
        LinkedList ll = new LinkedList(7);
        ll.add(ll, new LinkedList(9));
        ll.add(ll, new LinkedList(9));

        add1ToLL(ll);

        //ll.printList(ll);
        if (carry > 0) {
            LinkedList newNode = new LinkedList(carry);
            newNode.next = ll;
            ll = newNode;
        }
        ll.printList(ll);


    }

    int carry = 0;

    private void add1ToLL(LinkedList ll) {
        while (ll.next != null) {
            add1ToLL(ll.next);
            break;
        }
        if (ll.next == null) {
            int sum = ll.data + 1;
            carry = sum / 10;
            ll.data = sum % 10;
        } else if (carry > 0) {
            int sum = ll.data + 1;
            carry = sum / 10;
            ll.data = sum % 10;
        }
    }
}
