package HackerRank;

/*
Problem URL : https://www.hackerrank.com/challenges/absolute-permutation/problem
 */

import java.util.HashSet;
import java.util.Set;

public class absolutePermutation {

    private static int[] findPermutation(int n, int k) {

        int[] arr= new int[n];

        for(int i = 0;i<n;i++) {
            arr[i] = i+1;
        }

        boolean vis[] = new boolean[n+1];

        int flag = 0;
        for(int i = 0;i<n;i++) {
            int x = arr[i] - k;
            int y = arr[i] + k;

            if(x>0 && x<=n && !vis[x]){
                vis[x] = true;
                arr[i] = x;
            }
            else if(y>0 && y<=n && !vis[y]) {
                vis[y] = true;
                arr[i] = y;
            }
            else{
                flag = 1;
                break;
            }
        }
        if(flag == 1) {
            return new int[]{-1};
        }

        return arr;
    }

    public static void main(String[] args) {
        int n = 100;
        int k = 2;
        for(int a: findPermutation(n,k)) {
            System.out.println(a);
        }
    }
}
