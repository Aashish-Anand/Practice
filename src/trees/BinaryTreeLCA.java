package trees;

class Nodes {
	int data;
	Nodes left, right;
	
	Nodes(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
public class BinaryTreeLCA {

	Nodes root;
	
	private Nodes findLCA(Nodes node, int a, int b) {
		
		if(node == null) {
			return null;
		}
		
		if(node.data == a || node.data == b) {
			return node;
		}
		
		Nodes left = findLCA(node.left, a, b);
		Nodes right = findLCA(node.right, a,b);
		
		if(left != null && right!= null) {
			return node;
		}
		
		else {
			return left==null?right:left;
		}
		
	}
	public static void main(String[] args) {
		BinaryTreeLCA bt = new BinaryTreeLCA();
		bt.root = new Nodes(1);
		bt.root.left = new Nodes(2);
		bt.root.right = new Nodes(3);
		bt.root.left.left = new Nodes(4);
		bt.root.left.right = new Nodes(5);
		bt.root.right.left = new Nodes(6);
		bt.root.right.right = new Nodes(7);
		
		int first = 5;
		int second = 7;
		
		System.out.println(bt.findLCA(bt.root,first, second).data);
	}

}
