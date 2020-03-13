package gfg_self_paced;

import linkedList.LinkedList;

public class LinkedList_ReverseList {

    private static LinkedList reverse(LinkedList head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkedList temp = null;
        LinkedList nextNode = null;

        while(head!=null) {
            nextNode = head.next;
            head.next = temp;
            temp = head;
            head = nextNode;
        }
        head = temp;
        return head;
    }
    public static void main(String []args) {
        LinkedList ll = new LinkedList(1);
        LinkedList head = ll;
        ll.insert(head,2);
        ll.insert(head, 3);
        ll.insert(head,4);

        head = reverse(head);

        ll.print(head);
    }
}
