package linkedList;

public class SumLinkedList {
	LinkedList head1 = null;
	LinkedList head2 = null;
	
	int carry = 0;
	LinkedList curr = null;
	private void addLL(LinkedList head1, LinkedList head2, LinkedList res) {
		
		if(head1.next != null) {
			addLL(head1.next, head2.next, res);
		}
		
		int sum = head1.data +head2.data+carry;
		int val = sum % 10;
		carry = sum / 10;
		//res = curr;
		curr = new LinkedList(val);
		curr.next = res;
		res = curr;
				
	}
	
	public static void main(String [] args) {
		SumLinkedList obj = new SumLinkedList();
		obj.head1 = new LinkedList(1);
		obj.head1.next = new LinkedList(2);
		obj.head1.next.next = new LinkedList(3);
		
		obj.head2 = new LinkedList(1);
		obj.head2.next = new LinkedList(2);
		obj.head2.next.next = new LinkedList(3);
		
		LinkedList res = new LinkedList();
		
		obj.addLL(obj.head1, obj.head2, res);
		
		obj.head1.print(obj.head1);
		obj.head1.print(obj.head2);
		obj.head1.print(res);
		
		return ;
	}
}
