package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

public class AKACHOCO {
    public static void main(String[] args) {
        new AKACHOCO().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int x= sc.nextInt();
            int arr[] =  new int[n];

            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            System.out.println(findPossibility(n,x,arr));

        }
    }

    private String findPossibility(int n, int x, int arr[]) {
        int i = 0;
        int days = 1;
        while(i<n) {

            for(int j = i;j<x;j++){
                if(arr[i]-days <= 0){
                    return "Impossible";
                }
            }
            days++;
            i+= x;
        }
        return "Possible";
    }
}
