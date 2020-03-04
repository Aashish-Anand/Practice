package chefTeCode;

public class PIPSQUIK {
	public static void main(String[] args) {
		
		int n = 6;
		int h = 5;
		int y1 = 1; // duck
		int y2 = 2; // jump
		int life = 3; // life
		
		int arr1[] = {2,2,1,2,2,1};
		int arr2[] = {2,1,10,8,4,2};
		
		int barrier = 0;
		for(int i = 0;i<n;i++) {
			
			if(arr1[i] == 2 && arr2[i] <= y2) {
				barrier++;
			}
			else if(arr1[i] == 1 && arr2[i] >= (h-y1)) {
				barrier++;
			}
			else {
				--life;
				if(life==0) {
					break;
				}
				barrier++;
			}
		}
		System.out.println(barrier);
		
	}
}
