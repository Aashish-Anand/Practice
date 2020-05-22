package Leet;

import linkedList.LinkedList;

public class L328 {
    public static void main(String[] args) {
        new L328().run();
    }

    private void run() {
        LinkedList ll = new LinkedList(1);
        LinkedList head = ll;
        ll.insert(head,2);
//        ll.insert(head,3);
//        ll.insert(head,4);

        oddEven(head);
    }

    private void oddEven(LinkedList head) {
        if(head == null || head.next == null) {
            return;
        }

        LinkedList odd = head;
        LinkedList even = head.next;
        LinkedList evenHead = even;

        while(even!=null && even.next!=null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        LinkedList temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
