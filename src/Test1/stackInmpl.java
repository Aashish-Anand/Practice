package Test1;

import java.util.Scanner;
import java.util.Stack;

public class stackInmpl {
	
	private void push(Stack<Integer> s1 , Stack<Integer> s2, int val) {
		
		s1.push(val);
		
		if(s2.isEmpty()) {
			s2.push(val);
		}
		else {
			if(val<s2.peek()) {
				s2.push(val);
			}
			else {

				int min = s2.pop();
				
				if (!s2.isEmpty()) {
					if(val<s2.peek()) {
						s2.push(val);
					}
				}
				else {
					s2.push(val);
				}
				s2.push(min);
			}
		}
	}
	
	private Integer pop(Stack<Integer> s1, Stack<Integer> s2) {
		
		int popped ;
		if(s1.isEmpty()) {
			System.out.println("Nothing to pop");
			return -1;
		}
		else {
			popped = s1.pop();
			
			if(popped == s2.peek()) {  // if minimin element is same as popped element
				s2.pop();
			}
			else if(s2.size()>1) { // if
				
				int min = s2.pop();
				if(popped == s2.peek()) {
					s2.pop();
				}
				s2.push(min);
			}
		}
		return popped;
	}
	
	private Integer getSecMin(Stack<Integer> s2) {
		System.out.println("calling secondMin");
		int secMin;
		if(s2.isEmpty()) {
			System.out.println("Nothing to return as stack is empty");
			return -1;
		}
		else if(s2.size() == 1) {
			System.out.println("No Second minimum is present");
			return -1;
		}
		else {
			int min = s2.pop();
			secMin = s2.peek();
			s2.push(min);
			return secMin;
		}
		
	}
	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		stackInmpl obj = new stackInmpl();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		//int arr[] = {10,3,0,2
		do {
		int val = sc.nextInt();
		switch(val) {
			case 1: // push
					int numberToBePushed = sc.nextInt();
					obj.push(s1,s2, numberToBePushed);
					break;
			case 2 ://pop
					System.out.println(obj.pop(s1, s2));
					break;
			case 3 : //obj.getMinimum(s1,s2);
					 break;
			case 4 : System.out.println(obj.getSecMin(s2));
					 break;
		}
		ch = sc.nextInt();
		}while(ch == -1 );
	}

}
