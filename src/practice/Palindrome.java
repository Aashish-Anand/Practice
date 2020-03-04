package practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababa";
		int len = s.length();
		
		Stack<Character> stack = new Stack<>();
		int i = 0;
		while(i<len/2) {
			stack.push(s.charAt(i));
			i++;
		}
		if(len%2!=0) {
			i+=1;
		}
		while(i<len) {
			if(stack.peek()!= s.charAt(i)) {
				System.out.println("Not palindrome");
				break;
			}
			i++;
			stack.pop();
		}
		System.out.println("Palindrome");
		Set<Integer> s1 = new HashSet<>();
	}

}
