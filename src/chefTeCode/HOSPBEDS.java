package chefTeCode;

import java.util.Scanner;

public class HOSPBEDS {
    public static void main(String[] args) {
        new HOSPBEDS().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int arr[][] = new int[n][n];

            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }


            boolean flag = true;
            for(int i = 0;i<n;i++) {
                for(int j = 0;j<n;j++) {

                    if(arr[i][j]==1 && !check(arr, i, j, n)){
                        flag = false;
                        continue;
                    }
                }
                if(!flag) {
                    break;
                }
            }

            if(flag) {
                System.out.println("SAFE");
            }
            else {
                System.out.println("UNSAFE");
            }
        }
    }

    private boolean check(int arr[][], int i, int j, int n){
        int x[] = {-1,0,0,1};
        int y[] = {0, -1, 1, 0};

        for(int k = 0;k<4;k++) {

            int newx = i+x[k];
            int newy = j+y[k];


            if(newx>=0 && newy>=0 && newx<n && newy<n && arr[newx][newy] == 1) {
                return false;
            }
        }
        return true;
    }
}
