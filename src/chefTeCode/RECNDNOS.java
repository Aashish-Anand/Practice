package chefTeCode;

import javax.jnlp.IntegrationService;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class RECNDNOS {
    public static void main(String[] args) {
        new RECNDNOS().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int dish[] = new int[1001];
            Arrays.fill(dish, 0);
            int prevPos[] = new int[1001];
            Arrays.fill(prevPos, -1);

            for(int i = 0;i<n;i++) {
                int d = sc.nextInt();

                if(prevPos[d]==-1) {
                    prevPos[d] = i;
                    dish[d]++;
                }
                else{
                    if(Math.abs(prevPos[d]-i) != 1) {
                        prevPos[d] = i;
                        dish[d]++;
                    }
                }
            }

//            for(int i = 0;i<4;i++) {
//                System.out.println(prevPos[i]);
//            }
            int max = Integer.MIN_VALUE;
            int pos = -1;
            for(int i = 0;i<1001;i++) {
                if(dish[i] != -1 && dish[i] > max) {
                    max = dish[i];
                    pos = i;
                }
            }
            System.out.println(pos);
        }
    }
}
