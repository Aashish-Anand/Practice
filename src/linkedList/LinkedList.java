package linkedList;

public class LinkedList {

	int data;
	LinkedList next;
	
	LinkedList() {
		
	}
	LinkedList(int val) {
		data = val;
		next = null;
	}
	
	void insert(LinkedList head, int val) {
		LinkedList curr = head;
		
		LinkedList newElement = new LinkedList(val);
		
		while(curr.next!= null) {
			curr = curr.next;
		}
		curr.next = newElement;
	}
	
	void print(LinkedList head) {
		LinkedList curr = head;
		while(curr!=null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
