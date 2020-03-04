package linkedList;

public class LinkedList_Implementation {

	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	private void insert(int value) {
		
		Node new1 = new Node(value);
		new1.next = null;
		
		if(head == null) {
			head = new1;
			return;
		}
		
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = new1;
	}
	
	private void print() {
		Node first = head;
		while(first!=null) {
			System.out.print(first.data +" ");
			first = first.next;
		}
	}
	private void printReverse(Node temp) {
		if(temp == null) {
			return;
		}
		printReverse(temp.next);
		System.out.print(temp.data+" ");
	}
	
	public void insertAtPos(Node temp, int pos,int value) {
		int k = 1;
		Node curr = temp;
		Node p = null;
		while(k<pos && curr!=null) {
			p = curr;
			curr = curr.next;
			k++;
		}
		Node new1 = new Node(value);
		new1.next = p.next;
		p.next = new1;
	}
	
	public void deleteAnElement(Node temp, int value) {
		
		Node curr = temp;
		Node prev = null;
		
		while(curr!=null) {
			if(curr.data == value) {
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
	}
	
	public static void main(String[] args) {
		
		LinkedList_Implementation ll = new LinkedList_Implementation();
		
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		
		ll.print();
		System.out.println();
		Node temp = ll.head;
		ll.printReverse(temp);
		
		ll.insertAtPos(ll.head, 3, 6);  // head, position and value
		System.out.println();
		ll.print();
		
		ll.deleteAnElement(ll.head, 4); //  head and element to be deleted
		System.out.println();
		ll.print();
	}

}
