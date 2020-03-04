package linkedList;

public class MergeTwoSortedLL {

	public LinkedList merge2ll(LinkedList head1, LinkedList head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		if(head1.data < head2.data) {
			head1.next = merge2ll(head1.next, head2);
			return head1;
		}
		else {
			head2.next = merge2ll(head1, head2.next);
			return head2;
		}
	}
	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList(1);
		LinkedList head1 = ll1;
		ll1.insert(head1, 3);
		ll1.insert(head1, 5);
		ll1.insert(head1, 7);
		ll1.insert(head1, 9);

		LinkedList ll2 = new LinkedList(2);
		LinkedList head2 = ll2;
		ll2.insert(head2, 4);
		ll2.insert(head2, 6);
		ll2.insert(head2, 8);
		ll2.insert(head2, 10);
		
		MergeTwoSortedLL merge = new MergeTwoSortedLL();
		LinkedList newHead = merge.merge2ll(head1,head2);
		
		newHead.print(newHead);
	}

}
