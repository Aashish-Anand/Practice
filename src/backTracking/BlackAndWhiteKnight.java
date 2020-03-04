package backTracking;

import java.util.Scanner;

public class BlackAndWhiteKnight {
	
	public static int check(int i ,int j, int r, int c) {
		
		int row[] = {-2,-2,-1,1,-1,1,2,2};
		int col[] = {-1,1,2,2,-2,-2,-1,1};
		int count = 0;
		
		for(int k = 0;k<8;k++) {
			int row_x = i+row[k];
			int col_y = j+col[k];
			
			if(row_x >=0 && col_y>=0 && row_x < r && col_y < c) {
				count++;
			}
		}
		
		return ((r*c) - count -1);
	}
	public static int countPossibilities(int r, int c) {
		int sum = 0;
		for(int i = 0;i<r;i++) {
			for(int j = 0;j<c;j++) {
				
				sum = sum + check(i,j,r,c);
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			System.out.println(countPossibilities(r,c));
			
		}
		sc.close();
		return;
	}
}
