package chefTeCode;

import java.util.LinkedList;

public class PCYCLE {

	public static void main(String[] args) {
		int arr[] = {2,4,5,1,7,6,3,8};
		int len = arr.length;
		
		int count = 0;
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i = 1;i<=len;) {
			
			if(arr[i-1] >= 0) {
				ll.add(i);
				arr[i-1] = -arr[i-1];
				i = Math.abs(arr[i-1]);
				while(true) {
					if(arr[i-1] >= 0) {
						ll.add(i);
						arr[i-1] = -arr[i-1];
						i = Math.abs(arr[i-1]);
					}
					else {
						ll.add(i);
						ll.add(-100);
						count++;
						break;
					}
				}
			}
			else {
				i++;
			}
		}
		
		System.out.println(count);
		for(int a : ll) {
			if(a>0) {
				System.out.print(a+ " ");
			}
			else {
				System.out.println();
			}
		}
	}

}
