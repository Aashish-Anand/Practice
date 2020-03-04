package gfg_self_paced;

public class Arrays_Rotate_Array {

	public static int gcd(int a, int b) {
		if(b == 0) {
			return 1;
		}
		else {
			return gcd(b,a%b);
		}
	}
	public static void rotate(int arr[], int n, int d) {
		
		for(int i = 0;i<gcd(n,d);i++) {
			int temp = arr[i];
			int j = i;
			
			while(true) {
				int k = j+d;
				if(k>=n) {
					k= k-n;
				}
				if(k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		int d = 2;  // number of places to be rotated
		int n= arr.length;
		
		rotate(arr,n,d);
		
		for(int a: arr) {
			System.out.print(a+ " ");
		}
	}

}
