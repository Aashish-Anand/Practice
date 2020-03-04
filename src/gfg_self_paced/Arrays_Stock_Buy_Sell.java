package gfg_self_paced;

public class Arrays_Stock_Buy_Sell {

	public static void max_Profit(int arr[], int n) {
		
		int max = -1;
		int min = -1;
		for(int i = 0;i<n;i++) {
			
			if(i== 0 && arr[i]<=arr[i+1]) {
				min = i;
			}
			else if(i== n-1 && arr[i]>=arr[i-1]){
				max = i;
			}
			else if(i!=0 && i!=n-1 && arr[i]<=arr[i-1] && arr[i]<=arr[i+1]) {  // smaller than previous and next
				min = i;
			}
			else if(i!=0 && i!=n-1  && arr[i]>=arr[i-1] && arr[i]>=arr[i+1]) { // greater than previous and next
				max = i;
			}
			
			if(min != -1 && max != -1) {
				System.out.println(min +" " + max);
				min = -1;
				max = -1;
			}
		}
	}
	public static void main(String[] args) {
		
		int arr[] = {100,180,260,310,40,535,695};
		int len = arr.length;
		
		max_Profit(arr, len);
	}

}
