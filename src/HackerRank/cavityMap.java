package HackerRank;

public class cavityMap {

    private static String[] findCavityMap(String[] grid, int n) {
        if(grid.length < 3) {
            return grid;
        }
        StringBuilder strs[] = new StringBuilder[n];
        strs[0] = new StringBuilder(grid[0]);
        for(int i = 1;i<grid.length-1;i++) {
            StringBuilder temp = new StringBuilder(grid[i]);

            for(int j =1 ;j<grid[0].length()-1;j++) {

                int num = temp.charAt(j) - 48;

                if(num > grid[i-1].charAt(j) - 48 &&
                        num > grid[i].charAt(j-1) - 48 &&
                        num > grid[i+1].charAt(j) - 48 &&
                        num > grid[i].charAt(j+1) - 48) {

                    temp.setCharAt(j,'X');
                }
            }
            strs[i] = new StringBuilder(temp);
        }
        strs[n-1] = new StringBuilder(grid[n-1]);
        for(int i = 0;i<grid.length;i++) {
            grid[i] = strs[i].toString();
        }
        return grid;

    }
    public static void main(String [] args) {
        int n = 4;
        String []strs = {"1112","1912","1892","1234"};

        String []ans = findCavityMap(strs, n);

        for(String s : ans) {
            System.out.println(s);
        }
    }
}
