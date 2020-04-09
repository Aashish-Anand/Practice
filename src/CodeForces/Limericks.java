package CodeForces;

/*
https://codeforces.com/problemset/problem/1331/B
 */
import java.util.Scanner;

public class Limericks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i = 0;
        int first = 0;
        int second = 0;
        for(i = 2;i<=Math.sqrt(n);i++) {
            if(n%i == 0){
                first = i;
                second = n/i;
            }
        }
        StringBuilder string = new StringBuilder();
        string.append(first);
        string.append(second);

        System.out.println(Integer.parseInt(string.toString()));
    }
}
