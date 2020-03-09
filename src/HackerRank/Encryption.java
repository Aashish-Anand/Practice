package HackerRank;

/**
 * Problem URL : https://www.hackerrank.com/challenges/encryption/problem
 */
public class Encryption {

    public static void main(String []args) {
        String abc = "chillout";

        String newString = abc.replaceAll("\\s+","");
        double num = newString.length();

        int rows = (int) Math.floor(Math.sqrt(num));
        int cols = (int) Math.ceil(Math.sqrt(num));

        while(rows * cols <= num) {
            if((rows+1 * cols) <= (cols+1 * rows)){
                rows = rows+1;
            }
            else{
                cols = cols + 1;
            }
        }

        char mat[][] = new char[rows][cols];

        int count = 0;
        int flag = 0;
        for(int i = 0;i<rows;i++) {
               for(int j = 0;j<cols;j++) {
                   if(count >= newString.length()) {
                       flag = 1;
                       break;
                   }
                   mat[i][j] = newString.charAt(count++);
               }
               if(flag ==1){
                   break;
               }
        }

        for(int i = 0;i<rows;i++) {
            System.out.println();
            for(int j = 0;j<cols;j++) {
                System.out.print(mat[i][j]+" ");
            }
        }
        System.out.println();
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<=cols-1;i++) {
            str.append(" ");
            for(int j= 0;j<=rows-1;j++) {
                if(mat[j][i] >= 'a' && mat[j][i]<='z') {
                    str.append(mat[j][i]);
                }
            }
        }
        System.out.println(str.toString().trim());
        //System.out.println(newString);
    }
}
