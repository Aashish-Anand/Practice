package Leet.GenericDataStructure;

public class LinkedList {
    public int data;
    public LinkedList next;

    public LinkedList() {

    }
    public LinkedList(int data){
        this.data = data;
        this.next = null;
    }

    public void add(LinkedList head, LinkedList node) {
        while(head.next!=null) {
            head = head.next;
        }

        head.next = node;
    }

    public void printList(LinkedList head){
        while(head!=null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
