package skillenza;

import java.util.Scanner;

public class splitMilk {
    public static void main(String[] args) {
        new splitMilk().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int totalCapacity[] = new int[n];
            for(int i = 0;i<n;i++) {
                totalCapacity[i] = sc.nextInt();
            }

            int currentValue[] = new int[n];
            for(int i=0;i<n;i++) {
                currentValue[i] = sc.nextInt();
            }

            int spillover = 0;
            for(int i = 1;i<n;i++) {
                currentValue[i] = currentValue[i] + currentValue[i-1];

                if(currentValue[i]> totalCapacity[i]) {
                   spillover += (currentValue[i] - totalCapacity[i]);
                   currentValue[i] = totalCapacity[i];
                }
            }

            System.out.println(currentValue[n-1]+ " "+ spillover);
        }
    }
}
