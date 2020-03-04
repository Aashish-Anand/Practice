package trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Tree {
	int data;
	Tree left, right;
	
	Tree(int data) {
		this.data = data;
		left = right = null;
	}
}

public class TopView {

	Tree root;
	
	TopView(){
		root = null;
	}
	
	static class Map_Node_level{
		Tree node;
		int level;
		Map_Node_level(Tree node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	static void printTopView(Tree root) {
		
		Map<Integer, Integer> sortedMap = new TreeMap<Integer,Integer>(Collections.reverseOrder());
		
		Queue<Map_Node_level> q = new LinkedList<>();
		q.add(new Map_Node_level(root,0));
		
		while(!q.isEmpty()) {
			Map_Node_level temp = q.poll();
			
			Tree tr = temp.node;
			int level = temp.level;
			
			if(!sortedMap.containsKey(level)) {
				sortedMap.put(level, tr.data);
			}
			if(tr.left != null) {
				q.add(new Map_Node_level(tr.left, level + 1));
			}
			if(tr.right != null) {
				q.add(new Map_Node_level(tr.right, level - 1));
			}
		}
		
		for(Map.Entry<Integer, Integer> m : sortedMap.entrySet()) {
			System.out.print(m.getValue() + " ");
		}
	}
	
	public static void main(String[] args) {
		
		
		TopView tp = new TopView();
		tp.root = new Tree(1);
		tp.root.left = new Tree(2);
		tp.root.right = new Tree(3);
		tp.root.left.left = new Tree(4);
		tp.root.left.right = new Tree(5);
		tp.root.right.left = new Tree(6);
		tp.root.right.right = new Tree(7);
		
		printTopView(tp.root);
	}

}
