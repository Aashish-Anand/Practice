package chefTeCode;

public class STUPMACH {

	public static void main(String[] args) {
		
		int arr[] = {4,3,9,2};
		
		int leftMin = arr[0];
		int sum = arr[0];
		for(int i = 1;i<arr.length;i++) {
			if(leftMin<arr[i]) {
				sum+=leftMin;
			}
			else {
				leftMin = arr[i];
				sum+=leftMin;
			}
		}
	}

}
