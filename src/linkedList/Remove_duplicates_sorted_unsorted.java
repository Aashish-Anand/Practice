package linkedList;

public class Remove_duplicates_sorted_unsorted {

	public LinkedList removeDupUnsorted(LinkedList head) {
		
		if(head == null) {
			System.out.println("Head is empty");
			return null;
		}
		
		LinkedList first = head;

		while(first != null && first.next!=null) {
			LinkedList prev = first;
			LinkedList second = first.next;
			while(second!=null) {
				if(first.data == second.data) {
					prev.next = second.next;
				}else {
					prev = prev.next;
				}
				second = second.next;
			}
			first = first.next;
		}

		return head;
	}
	public LinkedList removeDup(LinkedList head) {
		if(head == null) {
			System.out.println("Head is empty");
			return null;
		}
		LinkedList first = head;
		LinkedList second = head.next;
		while(second!=null) {
			while(second!=null && first.data == second.data) {
				second = second.next;
			}
			first.next = second;
			first = first.next;
		}
		return head;
	}
	public static void main(String[] args) {
		Remove_duplicates_sorted_unsorted rr = new Remove_duplicates_sorted_unsorted();
		LinkedList ll = new LinkedList(1);
		LinkedList head = ll;
		ll.insert(head, 2);
		ll.insert(head, 2);
		ll.insert(head, 3);
		ll.insert(head, 4);
		ll.insert(head, 4);
		ll.insert(head, 7);
		ll.insert(head, 7);
		System.out.println("Before Anything");
		ll.print(head);
		
		head = rr.removeDup(head);
		
		System.out.println("After removing duplicate from sorted list");
		ll.print(head);
		
		LinkedList ll1 = new LinkedList(2);
		LinkedList head1 = ll1;
		ll1.insert(head1, 3);
		ll1.insert(head1, 3);
		ll1.insert(head1, 2);
		ll1.insert(head1, 6);
		ll1.insert(head1, 7);
		ll1.insert(head1, 7);
		ll1.insert(head1, 7);
		System.out.println("Before Anything");
		ll1.print(head1);
		
		head1 = rr.removeDupUnsorted(head1);
		
		System.out.println("After removing duplicate from unsorted list");
		ll.print(head1);
		
	}

}
