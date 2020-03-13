package linkedList;

public class LinkedList {

	public int data;
	public LinkedList next;
	
	public LinkedList() {
		
	}
	public LinkedList(int val) {
		data = val;
		next = null;
	}
	
	public void insert(LinkedList head, int val) {
		LinkedList curr = head;
		
		LinkedList newElement = new LinkedList(val);
		
		while(curr.next!= null) {
			curr = curr.next;
		}
		curr.next = newElement;
	}
	
	public void print(LinkedList head) {
		LinkedList curr = head;
		while(curr!=null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
