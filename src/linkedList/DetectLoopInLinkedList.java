package linkedList;

public class DetectLoopInLinkedList {

	public static void detectLoop(LinkedList head) {
		LinkedList slow = head;
		LinkedList fast = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		System.out.println(slow.data);
		System.out.println(fast.data);
		System.out.println("Loop detected.");
		
		System.out.println("Length of loop LL :");
		slow = slow.next;
		int length = 1;
		while(slow!= fast) {
			slow = slow.next;
			length++;
		}
		System.out.print(length);
		
		System.out.println();
		slow = head;
		while(slow!=fast) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println("Starting point of LL : " + slow.data);
		
		
		
	}
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList(1);
		LinkedList head = ll;
		
		ll.insert(head, 2);
		ll.insert(head, 3);
		ll.insert(head, 4);
		ll.insert(head, 5);
		
		LinkedList curr = head;
		while(curr.data != 2) {
			curr = curr.next;
		}
		LinkedList last = head;
		while(last.next!=null) {
			last = last.next;
		}
		last.next = curr;
		
		//ll.print(head);
		
		DetectLoopInLinkedList.detectLoop(head);
		
	}

}
