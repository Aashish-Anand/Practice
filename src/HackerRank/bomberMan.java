package HackerRank;

/*
Not yet completed
 */
public class bomberMan {

    private static boolean isSafe(int i, int j, int row, int col) {
        return (i>=0 && j>=0 && i<row && j<col);
    }
    private static String[] findFinalStage(String input[], int time) {

        int row = input.length;
        int col = input[0].length();
        int grid[][] = new int[row][col];

        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                if(input[i].charAt(j) == '.'){
                    grid[i][j] = -20;
                }
                else{
                    grid[i][j] = 0;
                }
            }
        }

        for(int i = 2;i<=time;i++) {
            if(i%3==1){

            }
            else {
                if(i%3==2){
                    for (int j = 0; j < grid.length; j++) {
                        for (int k = 0; k < grid[0].length; k++) {
                            if (grid[j][k] == -20) {
                                grid[j][k] = i;
                            }
                        }
                    }
                }
                for(int j = 0;j<grid.length;j++) {
                    for (int k = 0; k < grid[0].length; k++) {
                        if(i - grid[j][k]==3){
                            int temp = grid[j][k];
                            grid[j][k] = -20;
                            int x[] = {-1,0,0,1};
                            int y[] = {0,-1,1,0};
                            for(int a = 0;a<4;a++) {
                                if(isSafe(j+x[a], k+ y[a], grid.length, grid[0].length)){
                                    if( grid[j+x[a]][k+y[a]]!=temp) {
                                        grid[j + x[a]][k + y[a]] = -20;
                                    }
                                }
                            }
                        }
                    }
                }

            }
//            for(int k = 0;k<grid.length;k++) {
//                System.out.println();
//                for(int j = 0;j<grid[0].length;j++) {
//                    System.out.print(grid[k][j]+" ");
//                }
//            }
//            System.out.println();
        }

        String gridString[] = new String[row];

        for(int i = 0;i<grid.length;i++) {
            String temp = "";
            for(int j = 0;j<grid[0].length;j++) {
                if(grid[i][j]==-20) {
                    temp += ".";
                }
                else{
                    temp += "O";
                }
            }
            gridString[i] = temp;
        }
        return gridString;
    }
    public static void main(String[] args) {
        String grid[] = new String[] {".......",
                                      "...O...",
                                      "....O..",
                                      ".......",
                                      "OO.....",
                                      "OO....."};

//        String grid[] = new String[] {".......",
//                "...O.0.",
//                "....O..",
//                "..0....",
//                "OO...00",
//                "OO.0..."};
        int time = 3; // to find the grid condition after 6 seconds
        String gridString[] = findFinalStage(grid, time);
        for(int i = 0;i<gridString.length;i++) {
            System.out.println(gridString[i]);
        }
    }
}
