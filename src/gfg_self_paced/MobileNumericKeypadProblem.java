package gfg_self_paced;

public class MobileNumericKeypadProblem {
    public static void main(String[] args) {
        new MobileNumericKeypadProblem().run();
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

    private int findPossibleCombination(char[][] keypad, int n) {
        if(n == 1){
            return 10;
        }

        int count = 0;
        for(int i = 0;i<4;i++) {
            for(int j = 0;j<3;j++) {
                if(keypad[i][j]!='*' && keypad[i][j]!='#') {
                    count += findPossibleCombinationUtil(keypad, i,j, n);
                }
            }
        }
        return count;
    }

    int movex[] = {0, -1, 0, 1, 0};
    int movey[] = {0, 0, -1, 0, 1};
    private int findPossibleCombinationUtil(char keypad[][], int i, int j ,int n) {
        if(n==1){
            return 1;
        }

        int count =  0;
        for(int moves = 0;moves<5;moves++) {
            int newx = i + movex[moves];
            int newy = j + movey[moves];

            if(newx>=0 && newx<4 && newy>=0 && newy<3 && keypad[newx][newy]!='*'&& keypad[newx][newy]!='#') {
                count +=  findPossibleCombinationUtil(keypad, newx, newy, n-1);
            }
        }
        return count;
    }
}
