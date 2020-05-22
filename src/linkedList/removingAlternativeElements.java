package linkedList;

public class removingAlternativeElements {
    public static void main(String[] args) {
        new removingAlternativeElements().run();
    }

    private void run() {
        LinkedList ll = new LinkedList(1);
        LinkedList head = ll;
        ll.insert(head,2);
        ll.insert(head,3);
        ll.insert(head,4);

        make2LinkedList(ll);
    }

    private void make2LinkedList(LinkedList head) {
        if(head == null){
            return ;
        }
        if(head.next==null){
            return;
        }

        LinkedList temp = head;
        LinkedList nextTemp = head.next;

        while(nextTemp!=null){
            LinkedList newNode = new LinkedList(temp.data+100);
            newNode.next = nextTemp;
            temp.next = newNode;

            temp = nextTemp;
            nextTemp = nextTemp.next;
        }

        if(temp.next == null){
            LinkedList newLinkedList = new LinkedList(temp.data+100);
            temp.next = newLinkedList;
        }

        temp = head;

        LinkedList newHead = temp.next;
        LinkedList newTemp = newHead;

        temp.next = temp.next.next;
        temp = temp.next;

        while(temp.next.next!=null) {
            newTemp.next = temp.next;
            newTemp = newTemp.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        newTemp.next = temp.next;

        temp.next = null;

        temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
        newTemp = newHead;
         while(newTemp!=null) {
             System.out.print(newTemp.data+" ");
             newTemp = newTemp.next;
         }
        //return newHead;
    }
}

