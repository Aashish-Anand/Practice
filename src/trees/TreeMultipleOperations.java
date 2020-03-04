package trees;

import java.util.LinkedList;
import java.util.Stack;

/*
 * This class will have different operations to perform;
 * 1. Height;
 * 2. Level order
 * 3. Spiral Level Order
 * 4. Max Width
 * 5. Balanced
 * 6. Left view
 * 7. Right View
 */

class TreeNodes {
	int data;
	TreeNodes left, right;
	
	TreeNodes(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
public class TreeMultipleOperations {

	TreeNodes root;
	
	private void inOrder(TreeNodes root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data +" ");
		inOrder(root.right);
	}
	
	boolean balancedFlag = true;
	
	private int height(TreeNodes root) {
		if(root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		
		if(left- right < -1 || left - right > 1) {
			balancedFlag = false;
		}
		
		return Math.max(left, right) + 1;
	}
	
	private boolean balanced(TreeNodes root) {
		height(root);
		return balancedFlag;
	}
	
	private void levelOrder(TreeNodes root) {
		java.util.LinkedList<TreeNodes> queue = new java.util.LinkedList<>();
		
		if(root == null) {
			System.out.println("Nothing to print");
		}
		
		queue.add(root);
		while(!queue.isEmpty()) {
			System.out.print(queue.peek().data +" ");
			if(queue.peek().left != null) {
				queue.add(queue.peek().left);
			}
			if(queue.peek().right != null) {
				queue.add(queue.peek().right);
			}
			queue.poll();
		}
	}
	
	private void spiralLevel(TreeNodes root) {
		Stack<TreeNodes> s1 = new Stack<>();
		Stack<TreeNodes> s2 = new Stack<>();
		
		s1.add(root);
		
		while(!s1.isEmpty() || !s2.isEmpty() ) {
			
			while(!s1.isEmpty()) {
				TreeNodes temp = s1.peek();
				s1.pop();
				System.out.print(temp.data + " ");
				if(temp.left != null) {
					s2.push(temp.left);
				}
				if(temp.right!=null) {
					s2.push(temp.right);
				}
			}
			while(!s2.isEmpty()) {
				TreeNodes temp = s2.peek();
				s2.pop();
				System.out.print(temp.data + " ");
				if(temp.right != null) {
					s1.push(temp.right);
				}
				if(temp.left != null) {
					s1.push(temp.left);
				}
			}
		}
	}
	
	private int maxWidth(TreeNodes root) {
		LinkedList<TreeNodes> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int max = 1;
		while(!queue.isEmpty()) {
			TreeNodes temp = queue.peek();
			queue.poll();
			if(temp!=null) {
				if(temp.left != null) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
			else {
				if(queue.size() > max) {
					max = queue.size();
				}
				if(queue.size()>0) {
					queue.add(null);
				}
			}
		}
		return max;
	}
	
	private void leftView(TreeNodes root) {
		LinkedList<TreeNodes> queue = new LinkedList<>();
		queue.add(root);
		System.out.print(root.data + " ");
		queue.add(null);
		
		while(!queue.isEmpty()) {
			TreeNodes temp = queue.poll();
			if(temp!=null) {
				if(temp.left != null) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
			else {
				if(!queue.isEmpty()) {
					System.out.print(queue.peek().data + " ");
					queue.add(null);
				}
			}
		}
	}
	
	private void rightView(TreeNodes root) {
		LinkedList<TreeNodes> queue = new LinkedList<>();
		queue.add(root);
		//System.out.print(root.data + " ");
		queue.add(null);
		
		while(!queue.isEmpty()) {
			TreeNodes temp = queue.poll();
			if(queue.peek() == null && !queue.isEmpty()) {
				System.out.print(temp.data+" ");
			}
			if(temp!=null) {
				if(temp.left != null) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
			else {
				if(!queue.isEmpty()) {
					//System.out.print(queue.peek().data + " ");
					queue.add(null);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		TreeMultipleOperations t = new TreeMultipleOperations();
		
		t.root = new TreeNodes(1);
		t.root.left = new TreeNodes(2);
		t.root.right = new TreeNodes(3);
		t.root.left.left = new TreeNodes(4);
		t.root.left.right = new TreeNodes(5);
		t.root.right.left = new TreeNodes(6);
		t.root.right.right = new TreeNodes(7);
		t.root.left.left.left = new TreeNodes(8);
		
		System.out.print("InOrder Traversal : ");
		t.inOrder(t.root);
		System.out.println();
		
		System.out.println("Height of Tree : " + t.height(t.root));
		System.out.println();
		
		System.out.print("LevelOrder Traversal : ");
		t.levelOrder(t.root);
		System.out.println();
		
		System.out.print("Spiral Level Traversal : ");
		t.spiralLevel(t.root);
		System.out.println();
		
		System.out.print("Max Width : " + t.maxWidth(t.root));
		System.out.println();
		
		System.out.print("is Balanced : " + t.balanced(t.root));
		System.out.println();
		
		System.out.print("Left View : ");
		t.leftView(t.root);
		System.out.println();
		
		System.out.print("Right View : ");
		t.rightView(t.root);
		System.out.println();
	}

}
