package strings;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String arr[] = new String[2];
		for (int i = 0; i < 2; i++) {
			arr[i] = sc.nextLine();
		}

		Stack<String> stack = new Stack<>();
		for (int i = 0; i < 2; i++) {

			int size = arr[i].length();

			int j = 0;

			String str = "";

			while (j < size) {
				char ch = arr[i].charAt(j);
				if (ch == ' ' && !str.equals("")) {
					stack.push(str);
					str = "";
				}
				else if (ch == '\r' || ch == '\n' || ch == '.' || ch == ':' || ch == ';') {

				} else {
					str = str + ch;
				}
				j++;
			}
			stack.push(str);
			stack.push("123");
		}
		int totalSize = stack.size();
		// System.out.println(totalSize);
		while (!stack.isEmpty()) {

			if (stack.peek().equals("123") && totalSize != stack.size()) {
				System.out.println();
			} else if(!stack.peek().equals("123") ){
				System.out.print(stack.peek() + " ");
			}
			stack.pop();
		}
	}
	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

}
