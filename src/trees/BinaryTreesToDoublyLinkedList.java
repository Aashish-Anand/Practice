package trees;

/*
 * 
 */

class Node {
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinaryTreesToDoublyLinkedList {

	Node root;
	
	public BinaryTreesToDoublyLinkedList() {
		root = null;
	}
	
	public void printInOrder(Node root) {
		if( root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}
	
	public void convertBTToDLL(Node root) {
		if(root == null) {
			return;
		}
		
		Node node = convertBTToDLLUtil(root);
		while(node.left!=null) {
			node = node.left;
		}
		
		Node head = node;
		System.out.println();
		while(head!= null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}
	
	Node convertBTToDLLUtil(Node root) {
		
		if(root == null){
			return null;
		}
		
		if(root.left != null) {
			Node left = convertBTToDLLUtil(root.left);
			
			for(;left.right!=null;left = left.right);
			
			left.right = root;
			root.left = left;
		}
		
		if(root.right != null) {
			Node right = convertBTToDLLUtil(root.right);
			
			for(;right.left!=null;right = right.left);
			right.left = root;
			root.right = right;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
		BinaryTreesToDoublyLinkedList bt = new BinaryTreesToDoublyLinkedList();
		
		bt.root = new Node(10);
		bt.root.left = new Node(12);
		bt.root.right = new Node(15);
		bt.root.left.left = new Node(25);
		bt.root.left.right = new Node(30);
		bt.root.right.left = new Node(36);
		bt.printInOrder(bt.root);
		bt.convertBTToDLL(bt.root);
		
	}
}
