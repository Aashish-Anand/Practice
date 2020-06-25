package Leet;

import linkedList.LinkedList;

public class L148 {
    public static void main(String[] args) {
        new L148().run();
    }
    private void run() {
        LinkedList ll = new LinkedList(8);
        ll.insert(ll,7);
        ll.insert(ll,6);
        ll.insert(ll,5);
        ll.insert(ll,4);
        ll = sortList(ll);
        ll.print(ll);
    }

    private LinkedList sortList(LinkedList head) {
        if(head == null || head.next == null){
            return head;
        }
        LinkedList mid = findMid (head);
        LinkedList secondHalf = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(secondHalf));
    }
    private LinkedList findMid(LinkedList head) {
        if(head == null){
            return null;
        }
        LinkedList slow = head;
        LinkedList fast = head;

        while(fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private LinkedList merge(LinkedList head1 , LinkedList head2) {
        if(head1 == null){
            return head2;
        }
        if(head2== null){
            return head1;
        }
        if(head1.data < head2.data){
            head1.next = merge(head1.next, head2);
            return head1;
        }
        else{
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
}

