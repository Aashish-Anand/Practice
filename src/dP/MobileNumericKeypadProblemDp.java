package dP;

public class MobileNumericKeypadProblemDp {
    public static void main(String[] args) {
        new MobileNumericKeypadProblemDp().run();
    }
    private void run() {
        char keyPad[][] = {{'1','2','3'},
                {'4','5','6'},
                {'7','8','9'},
                {'*','0','#'}};

        System.out.println(findPossibleCombination(keyPad,1));
        System.out.println(findPossibleCombination(keyPad,2));
        System.out.println(findPossibleCombination(keyPad,3));
        System.out.println(findPossibleCombination(keyPad,4));
        System.out.println(findPossibleCombination(keyPad,30));
    }

    private long findPossibleCombination(char[][] keypad, int n) {

        if(n==1) {
            return 10;
        }

        long count[][] = new long[10][n+1];

        for(int i = 0;i<10;i++) {
            count[i][0] = 0;
            count[i][1] = 1;
        }

        int x[] = {0,-1,0,1,0};
        int y[] = {0,0,-1, 0,1};
        for(int k=2;k<=n;k++) {
            for(int i = 0;i<4;i++) {
                for(int j = 0;j<3;j++) {

                    if(keypad[i][j]!='*' && keypad[i][j]!='#') {
                        int num = keypad[i][j]-'0';
                        count[num][k] = 0;
                        for (int move = 0;move<5;move++) {
                            int newx = i + x[move];
                            int newy = j + y[move];
                            if(newx >=0 && newx<4 && newy>=0 && newy<3 && keypad[newx][newy]!='*' && keypad[newx][newy]!='#') {

                                int newNum = keypad[newx][newy]-'0';
                                count[num][k] += count[newNum][k-1];
                            }
                        }
                    }
                }
            }
        }

        long totalCombo = 0;
        for(int i = 0;i<10;i++) {
            totalCombo += count[i][n];
        }

        return totalCombo;
    }
}
