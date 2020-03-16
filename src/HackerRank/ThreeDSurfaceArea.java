package HackerRank;

/*
Problem Url : https://www.hackerrank.com/challenges/3d-surface-area/problem
 */
public class ThreeDSurfaceArea {

    private static boolean isSafe(int i,int j, int row, int col){
        if(i>=0 && j>=0 && i<row && j<col) {
            return true;
        }
        return false;
    }
    private static int findSurfaceArea(int a[][]) {
        int row = a.length;
        int col = a[0].length;
        int area = 2*row*col;

        int x[] = {0,-1,0,1};
        int y[] = {-1,0,1,0};
        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                for(int k = 0;k<4;k++) {
                    int newX = i + x[k];
                    int newY = j + y[k];
                    if (isSafe(newX, newY, row,col)) {
                        if(a[newX][newY] < a[i][j]) {
                            area += (a[i][j]-a[newX][newY]);
                        }
                    } else {
                        area += a[i][j];
                    }
                }
            }
        }
        return area;
    }
    public static void main(String[] args) {

        int a[][]= {{1,3,4},{2,2,3},{1,2,4}};

        System.out.println(findSurfaceArea(a));
    }
}
