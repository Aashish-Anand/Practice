package gfg_self_paced;

import linkedList.LinkedList;

import javax.sound.sampled.Line;

public class LinkedList_Merge2SortedLL {

    private static LinkedList merge (LinkedList head1, LinkedList head2) {
        if(head1==null) {
            return head2;
        }
        else if(head2 == null) {
            return head1;
        }
        if(head1.data < head2.data) {
            head1.next = merge(head1.next, head2);
            return head1;
        }
        else{
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }

    public static void main(String []args) {
        LinkedList ll1 = new LinkedList(1);
        LinkedList head1 = ll1;
        ll1.insert(head1,3);
        ll1.insert(head1, 5);
        ll1.insert(head1, 7);
        //ll1.print(head1);

        LinkedList ll2 = new LinkedList(2);
        LinkedList head2 = ll2;
        ll2.insert(head2,4);
        ll2.insert(head2, 6);
        ll2.insert(head2, 8);
        //ll2.print(head2);

        head1 = merge(head1,head2);
        ll1.print(head1);
    }
}
