package Leet;

import linkedList.LinkedList;

public class L143 {
    public static void main(String[] args) {
        new L143().run();
    }

    private void run() {
        LinkedList ll = new LinkedList(1);
        LinkedList head = ll;
        ll.insert(head,2);
        ll.insert(head,3);
//        ll.insert(head,4);

        reOrderIt(head);
    }

    private LinkedList reOrderIt(LinkedList head) {

        if(head==null || head.next==null){
            return head;
        }
        LinkedList temp = head;

        while(temp!=null){
            temp.next = reverseList(temp.next);
            temp = temp.next;
        }

        temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        return null;
    }

    private LinkedList reverseList(LinkedList head){

        if(head == null){
            return null;
        }
        LinkedList  prev = null;

        while(head.next!=null) {
            LinkedList next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }
}
