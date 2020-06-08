package Leet;


import Leet.GenericDataStructure.LinkedList;
import sun.awt.image.ImageWatched;

public class L445 {
    public static void main(String[] args) {
        new L445().run();
    }

    private void run() {
        LinkedList ll1 = new LinkedList();

//        ll1.add(ll1, new LinkedList(9));
//        ll1.add(ll1, new LinkedList(9));
        ll1.add(ll1, new LinkedList(2));
        ll1.add(ll1, new LinkedList(3));

        LinkedList ll2 = new LinkedList();
        ll2.add(ll2, new LinkedList(9));
        ll2.add(ll2, new LinkedList(9));

        LinkedList ll = addTwoLinkedList(ll1.next, ll2.next);

        ll.printList(ll);
    }

    private LinkedList addTwoLinkedList(LinkedList head1, LinkedList head2) {
        if(head1 == null) {
            return head2;
        }
        else if(head2 == null){
            return head1;
        }
        LinkedList temp1 = head1;
        LinkedList temp2 = head2;

        int len1 = 0;
        int len2 = 0;

        while (temp1 != null) {
            temp1 = temp1.next;
            len1++;
        }

        while (temp2 != null) {
            temp2 = temp2.next;
            len2++;
        }

        if (len2 > len1) {
            temp1 = head1;
            head1 = head2;
            head2 = temp1;
        }

        temp1 = head1;
        int i = 0;

        while (i < Math.abs(len1 - len2)) {
            temp1 = temp1.next;
            i++;
        }

        addEqualParts(temp1, head2);

        if(len1!=len2) {
            addRemainingPart(head1, temp1);
        }
        if(carry>0){
            LinkedList newNode = new LinkedList(carry);
            newNode.next = head1;
            head1 = newNode;
        }
        return head1;
    }

    int carry = 0;
    private void addEqualParts(LinkedList head1 , LinkedList head2) {
        if(head1.next!=null){
            addEqualParts(head1.next, head2.next);
        }

        int sum = head1.data+head2.data+carry;
        carry = sum/10;
        head1.data = sum%10;
    }
    private void addRemainingPart(LinkedList head1, LinkedList temp) {
        if(head1.next!=temp) {
            addRemainingPart(head1.next,temp);
        }
        int sum = head1.data+carry;
        carry = sum/10;
        head1.data = sum%10;
    }
}
