package gfg_self_paced;

import linkedList.LinkedList;

public class LinkedList_MergeSort {

    private static LinkedList merge(LinkedList head1, LinkedList head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data < head2.data) {
            head1.next = merge(head1.next, head2);
            return head1;
        }
        else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }

    private static LinkedList findMid(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /*
        Here we are breaking the connection i.e.
        2->1->4->3->6->5
         to 2->1->4 and 3->6->5
         */
        LinkedList temp = slow.next;
        slow.next = null;
        return temp;
    }

    private static LinkedList mergeSort(LinkedList head1) {
        if (head1 == null || head1.next == null) {
            return head1;
        }
        LinkedList mid = findMid(head1);
        return merge(mergeSort(head1), mergeSort(mid));
    }

    public static void main(String[] args) {
        LinkedList head1 = new LinkedList(1);
        head1.insert(head1, 3);
        head1.insert(head1, 2);
        head1.insert(head1, 5);
        head1.insert(head1, 4);
        head1.insert(head1, 7);
        head1.insert(head1, 6);

        head1 = mergeSort(head1);

        head1.print(head1);
    }
}
