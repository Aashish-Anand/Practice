package chefTeCode;

import java.util.Arrays;
import java.util.Scanner;

/*
Very good question
https://www.codechef.com/LRNDSA02/problems/NOTALLFL
 */
public class NOTALLFL {
    public static void main(String[] args) {
        new NOTALLFL().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int l = 0;
            int r = 0;
            int maxDist = 1;

            int flavor[] = new int[k+1];
            Arrays.fill(flavor,0);
            int flavourEncountered = 1;
            flavor[arr[0]] = 1;

            while(true) {

                while(++r<n && flavourEncountered<k) {
                    if(flavor[arr[r]] == 0) {
                        flavourEncountered++;
                    }
                    flavor[arr[r]]++;
                   // System.out.println(l+" "+r);
                    if(flavourEncountered<k) {
                        maxDist = Math.max(maxDist, r - l + 1);
                    }
                }
                if(r==n){
                    break;
                }
                r--;
                while(l<=r && flavourEncountered==k){
                    if(flavor[arr[l]]==1){
                        flavourEncountered--;
                    }
                    flavor[arr[l]]--;
                    l++;
                }

            }
            System.out.println(maxDist);

        }
    }
}
