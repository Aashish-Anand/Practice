package Leet;

public class L86 {
    public static void main(String[] args) {
        new L86().run();
    }
    private void run() {

        LinkedList head = new LinkedList(1);

        head.add(head, new LinkedList(4));
        head.add(head, new LinkedList(3));
        head.add(head, new LinkedList(2));
        head.add(head, new LinkedList(5));
        head.add(head, new LinkedList(2));

        head.printList(head);

        int num = 3;
        System.out.println();
        head = partitionList(head, num);
        head.printList(head);
    }

    private LinkedList partitionList(LinkedList head, int num) {
        LinkedList temp = head;
        LinkedList p = null;

        while(temp.data<num) {
            p = temp;
            temp = temp.next;
        }
        LinkedList pnext = temp;

        LinkedList newP = temp;
        while(temp!=null) {

            if(temp.data<num){
                newP.next = temp.next;
                if(p==null){
                    p =temp;
                    p.next = pnext;
                    head = p;
                }
                else {
                    temp.next = pnext;
                    p.next = temp;
                    p = p.next;
                    //p.next = pnext;
                }
                temp = newP.next;
            }
            else{
                newP = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
