package chefTeCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ENDGAME {
    public static void main(String[] args) {
        new ENDGAME().run1();
    }


    //method 1
    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();

            int arr[][] = new int[r][c];

            arr[x][y] = 1;

            System.out.println(checkDays(arr, x,y, r, c));
        }
    }

    private int checkDays(int arr[][], int x, int y, int r, int c) {
        int count = 0;

        while(true) {
            count++;
            boolean zeroPresent = false;
            for(int i = 0;i<r;i++) {
                for(int j = 0;j<c;j++) {
                    if(arr[i][j] == 1) {
                        populateNeighbour(arr, i, j, r,c);
                    }
                }
            }

            for(int i = 0;i<r;i++) {
                for (int j = 0; j < c; j++) {
                    if(arr[i][j] ==2) {
                        arr[i][j]=1;
                    }
                    if(arr[i][j]==0) {
                        zeroPresent = true;
                    }
                    //System.out.print(arr[i][j]+" ");
                }
                //System.out.println();
            }

//            for(int i = 0;i<r;i++) {
//                for (int j = 0; j < c; j++) {
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            if(!zeroPresent) {
                break;
            }
        }
        return count;
    }

    private void populateNeighbour(int arr[][], int i ,int j, int r,int c){

        int x[] = {-1,0,0,1,-1,1,-1,1};
        int y[] = {0,-1,1,0,-1,-1,1,1};

        for(int k = 0;k<8;k++) {

            int newx = i + x[k];
            int newy = j + y[k];

            if(newx>=0 && newy>=0 && newx<r && newy<c && arr[newx][newy]==0) {
                arr[newx][newy] = 2;
            }
        }
    }

    // method 2  -- runs for large inputs

    private void run1() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            long r = sc.nextLong();
            long c = sc.nextLong();

            long x = sc.nextLong();
            long y = sc.nextLong();

            Set<String> set = new HashSet<>();

            set.add(x+" "+y);
            Set<String> set2 = new HashSet<>();

            int count = 0;
            while(true) {
                count++;
                if(!set2.isEmpty()){
                    set.addAll(set2);
                    set2.clear();
                }
                for(long i = 0;i<r;i++) {
                    for(int j = 0;j<c;j++) {

                        if(set.contains(i+" "+j)) {
                            int xaxis[] = {-1,0,0,1,-1,1,-1,1};
                            int yaxis[] = {0,-1,1,0,-1,-1,1,1};

                            for (int k = 0; k < 8; k++) {

                                long newx = i + xaxis[k];
                                long newy = j + yaxis[k];

                                if(newx>=0 && newy>=0 && newx<r && newy<c) {
                                    String str = newx + " " + newy;
                                    if (!set.contains(str) && !set2.contains(str)) {
                                        set2.add(str);
                                    }
                                }
                            }
                        }
                    }
                }
                //System.out.println(set.size());

                if(set.size() + set2.size() == r*c) {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
