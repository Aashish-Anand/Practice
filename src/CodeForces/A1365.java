package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1365 {
    public static void main(String[] args) throws IOException {
        new A1365().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            String s[] = reader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String str[] = reader.readLine().split(" ");
                for(int j = 0;j<m;j++){
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            int flag = 0;
            int rowCount = 0;
            int i = 0;
            while(i<n) {
                flag = 0;
                for(int j = 0;j<m;j++) {
                    if(arr[i][j]==1){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    rowCount++;
                }
                i++;
            }

            flag = 0;
            int columnCount = 0;
            i = 0;
            while(i<m){
                flag = 0;
                for(int j = 0;j<n;j++) {
                    if(arr[j][i]==1){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    columnCount++;
                }
                i++;
            }

            //System.out.println(rowCount+" "+columnCount);

            rowCount = rowCount<columnCount?rowCount:columnCount;

            if((rowCount)%2 == 0){
                System.out.println("Vivek");
            }
            else{
                System.out.println("Ashish");
            }
        }
    }
}
