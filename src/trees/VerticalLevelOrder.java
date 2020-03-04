package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
	int data;
	TreeNode left, right;
	
	TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
public class VerticalLevelOrder {

	TreeNode root;
	
	static class Object{
		TreeNode node;
		int level;
		Object(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	private void verticalOrderTraversal(TreeNode root) {
		
		/*
		 * This map will store the list of all node at particular node;
		 */
		Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
		
		Queue<Object> q = new LinkedList<>();
		
		map.put(0,new ArrayList<>(root.data));
		q.add(new Object(root,0));
		
		while(!q.isEmpty()) {
			Object temp = q.peek();
			q.poll();
			
			TreeNode node = temp.node;
			int lvl = temp.level;
			
			if(map.containsKey(lvl) && node!=root) {
				ArrayList<Integer> tempList = map.get(lvl);
				tempList.add(node.data);
				map.put(lvl, tempList);
			}
			else {
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(node.data);
				map.put(lvl, tempList);
			}
			
			if(node.left != null) {
				q.add(new Object(node.left, lvl - 1));
			}
			if(node.right != null) {
				q.add(new Object(node.right, lvl + 1));
			}
		}
		
		for(Map.Entry<Integer, ArrayList<Integer>> m: map.entrySet()) {
			for(Integer i : m.getValue()) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		VerticalLevelOrder v = new VerticalLevelOrder();
		v.root = new TreeNode(1);
		v.root.left = new TreeNode(2);
		v.root.right = new TreeNode(3);
		v.root.left.left = new TreeNode(4);
		v.root.left.right = new TreeNode(5);
		v.root.right.left = new TreeNode(6);
		v.root.right.right = new TreeNode(7);
		
		v.verticalOrderTraversal(v.root);
	}

}
