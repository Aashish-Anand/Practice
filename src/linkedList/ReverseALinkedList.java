package linkedList;

public class ReverseALinkedList {

	public LinkedList reverse(LinkedList head) {
		if(head == null) {
			return null;
		}
		LinkedList newNode = null;
		LinkedList prev = null;
		while(head!=null) {
			newNode = head.next;
			head.next = prev;
			prev = head;
			head = newNode;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList(1);
		LinkedList head1 = ll;
		
		ll.insert(head1, 2);
		ll.insert(head1, 3);
		ll.insert(head1, 4);
		ll.insert(head1, 5);
		ll.insert(head1, 6);
		ll.insert(head1, 7);
		
		ll.print(head1);
		ReverseALinkedList rl = new ReverseALinkedList();
		head1 = rl.reverse(head1);
		System.out.println("After reversal");
		ll.print(head1);
	}

}
