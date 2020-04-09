package CodeForces;

import java.util.Scanner;

/*
https://codeforces.com/problemset/problem/393/A
 */
public class Nineteen {
    public static void main(String[] args) {
        new Nineteen().run();
    }
    private void run(){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int n = 3;
        int e = 3;
        int t = 1;
        int i = 1;

        int arr[] = new int[26];

        for(int j = 0;j<str.length();j++) {
            arr[str.charAt(j)-'a']++;
        }

        int count = 0;

        //count = Math.min(arr['n'-'a']/n, Math.min(arr['e'-'a']/e, Math.min(arr['t'-'a']/t,arr['i'-'a']/i)));
        count = Math.min(arr['e'-'a']/e, Math.min(arr['t'-'a']/t,arr['i'-'a']/i));
        System.out.println((arr['n'-'a']));
        if((arr['n'-'a'] - 1)/2 < count){
            count = (arr['n'-'a']-1)/2;
        }

        System.out.println(count);


    }
}
