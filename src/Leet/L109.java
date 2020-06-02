package Leet;

public class L109 {
    public static void main(String[] args) {
        new L109().run();
    }

    private void run() {

        LinkedList head = new LinkedList(-10);

        head.add(head, new LinkedList(-3));
        head.add(head, new LinkedList(0));
        head.add(head, new LinkedList(5));
        head.add(head, new LinkedList(9));
//        head.add(head, new LinkedList(6));

        Tree root = sortedListToBST(head);
        root.inOrder(root);
    }
    private Tree sortedListToBST(LinkedList head){

        if(head == null){
            return null;
        }
        if(head.next==null){
            return new Tree(head.data);
        }

        LinkedList mid = findMid(head);
        if(prev!=null) {
            prev.next = null;
        }

        LinkedList midNext = mid.next;
        mid.next = null;

        Tree root = new Tree(mid.data);

        if(head!=mid) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(midNext);

        return root;
    }

    LinkedList prev ;
    private LinkedList findMid(LinkedList head) {
        prev = null;
        LinkedList slow = head;
        LinkedList fast = head;

        while(fast.next!=null && fast.next.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
