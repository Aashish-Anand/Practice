package chefTeCode;

import java.lang.reflect.Array;
import java.util.*;

public class FENCE {
    public static void main(String[] args) {
        new FENCE().run();
    }


    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            long n = sc.nextLong();
            long m = sc.nextLong();
            long k = sc.nextLong();

            Set<String> set  = new HashSet<>();

            long fences = 0;

            for(int i = 0;i<k;i++) {
                long r = sc.nextLong();
                long c = sc.nextLong();

                int xIndex[] = {-1, 0, 0, 1};
                int yIndex[] = {0, -1 , 1, 0};

                for(int j = 0;j<4;j++) {
                    long newX = r + xIndex[j];
                    long newY = c + yIndex[j];

                    if(!set.contains(newX+" "+newY)) {
                        fences += 1;
                    }else{
                        fences-=1;
                    }
                }
                set.add(r+" "+c);
            }
            System.out.println(fences);
        }
    }

    // partially accepted
//    private void run() {
//        Scanner sc = new Scanner(System.in) ;
//
//        int t = sc.nextInt();
//        while(t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//
//            long arr[][] = new long[n][m];
//            //Arrays.fill(arr, 0);
//
//            int k = sc.nextInt();
//
//            for(int i = 0;i<k;i++) {
//                int r = sc.nextInt();
//                int c = sc.nextInt();
//                arr[r-1][c-1] = 1;
//            }
//
//            long count = 0;
//            for(int i = 0;i<n;i++) {
//                for(int j = 0;j<m;j++) {
//
//                    if(arr[i][j] ==1) {
//
//                        long fences =
//                                check(i-1,j,n,m,arr)+ check(i,j-1,n,m,arr)+check(i+1, j,n,m,arr)+check(i,j+1,n,m,arr);
//
//                        //System.out.println(i+ " " + j+" "+fences);
//                        count+= fences;
//                    }
//                }
//            }
//            System.out.println(count);
//
//        }
//    }
//
//    private long check(int i , int j, int n, int m, long arr[][]) {
//        if(i>=0 && j>=0 && i<n && j<m && arr[i][j]!=1) {
//            return 1;
//        }
//        if(i<0 || j<0 || i>n-1 || j>m-1) {
//            return 1;
//        }
//        return 0;
//    }
}
