package trees;

abstract class abc {
	int a ;
	abc(int a){
		this.a = a;
	}
}
class abcd extends abc {
	abcd(int a) {
		super(a);
	}
}
public class RootToLeaf {
	abcd b = new abcd(4);
	private void printAllPath(Tree root) {
		pathIterate(root, new int[1000], 0);
	}
	
	private void pathIterate(Tree node, int arr[], int index) {
		if(node!= null) {
			arr[index] = node.data;
			index++;
		}
		
		if(node.left == null && node.right == null)  {
			printingThePath(arr, index);
		}
		
		else {
			pathIterate(node.left, arr, index);
			pathIterate(node.right, arr, index);
		}
	}
	
	private void printingThePath(int arr[], int index) {
		for(int i = 0;i<index;i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}

	Tree root;
	public static void main(String[] args) {
		RootToLeaf n = new RootToLeaf();
		n.root = new Tree(1);
		n.root.left = new Tree(2);
		n.root.right = new Tree(3);
		n.root.left.left = new Tree(4);
		n.root.left.right = new Tree(5);
		n.root.right.left = new Tree(6);
		n.root.right.right = new Tree(7);
		
		n.printAllPath(n.root);
	}

}
