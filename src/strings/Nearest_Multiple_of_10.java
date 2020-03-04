package strings;

import java.util.Scanner;

public class Nearest_Multiple_of_10 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        
        int t = Integer.parseInt(a);
        
        while(t-- > 0) {
            
            String n = sc.nextLine();
            String[] arr = n.split("");
            //System.out.print(arr[1]);;

            int carry = 0;
            for(int i = n.length()-1;i>=0;i--) {
            	int num = Integer.parseInt(arr[i]);
            	if(num >= 0 && num <= 5) {
            		int number = 0;
            		if(carry == 1 ) {
            			number = num+carry;
            		}
            		arr[i] = Integer.toString(number);
            		break;
            	}
            	else if(num >5 && num <= 9){
            		arr[i] = "0";
            		carry = 1;
            	}
            }
        }
        sc.close();
    
	}

}
