package linkedList;

public class MergeSort_A_LinkedList {

	public static LinkedList merge(LinkedList head1, LinkedList head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		if(head1.data < head2.data) {
			head1.next = merge(head1.next, head2);
			return head1;
		}
		else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
	}
	public static LinkedList findMid(LinkedList head) {
		LinkedList slow = head;
		LinkedList fast = head;
		
		while(fast.next!=null && fast.next.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		LinkedList temp = slow.next;
		slow.next = null;
		return temp;
	}
	public static LinkedList mergeSort(LinkedList head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		LinkedList mid = findMid(head);
		
		return merge(mergeSort(head), mergeSort(mid));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList ll = new LinkedList(1);
		LinkedList head = ll;
		ll.insert(head, 5);
		ll.insert(head, 2);
		ll.insert(head, 4);
		ll.insert(head, 3);
		
		LinkedList curr = mergeSort(head);
		ll.print(curr);
	}

}
