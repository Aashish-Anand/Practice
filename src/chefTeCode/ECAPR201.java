package chefTeCode;

import java.util.Scanner;

public class ECAPR201 {
    public static void main(String[] args) {
        new ECAPR201().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int len = sc.nextInt();
            String str = sc.next();
            int arr[] = new int['z'-'a'+1];

            for(char a : str.toCharArray()) {
                arr[a - 'a']++;
            }

            for(int i = 0;i<26;i++) {
                if(arr[i]!=0){
                    System.out.println((char)('a'+i));
                    break;
                }
            }
        }
    }
}
