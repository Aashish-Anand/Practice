package gfg_interview_prep;

import java.util.Scanner;

public class findNthRootOfM {
    public static void main (String[] args)
    {
        //code

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0) {
            long root = sc.nextLong();
            long M = sc.nextLong();
            long num = findRoot(root, M);
            if(num > 0){
                System.out.println(num);
            }
            else{
                System.out.println(-1);
            }
        }
    }

    private static long findRoot(long root, long M) {

        System.out.println(root+" "+M);
        long num = (long)Math.pow(M,((float)1/root));
        System.out.println(num);

        if((long)Math.pow(num, root) == M){
            return num;
        }
        return -1;

    }
}
