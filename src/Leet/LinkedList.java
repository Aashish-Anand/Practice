package Leet;

public class LinkedList {
    int data;
    LinkedList next;

    LinkedList() {

    }
    LinkedList(int data){
        this.data = data;
        this.next = null;
    }

    void add(LinkedList head, LinkedList node) {
        while(head.next!=null) {
            head = head.next;
        }

        head.next = node;
    }

    void printList(LinkedList head){
        while(head!=null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
