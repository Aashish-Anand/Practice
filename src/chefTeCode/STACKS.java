package chefTeCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class STACKS {
    public static void main(String[] args) {
        new STACKS().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            int arr[] = new int[n];

            for(int i = 0;i<n;i++) {
                arr[i] = sc.nextInt();
            }

//            LinkedList<Long> list = new LinkedList<>();
//
//            for(int i = 0;i<n;i++) {
//                if(arr[i]!=-1) {
//                    long min = arr[i];
//
//                    for (int j = i + 1; j < n; j++) {
//                        if (arr[j] < min && arr[j] != -1) {
//                            min = arr[j];
//                            arr[j] = -1;
//                        }
//                    }
//                    list.add(min);
//                    arr[i] = -1;
//                }
//            }
//            System.out.print(list.size() +" ");
//            for(Long a : list) {
//                System.out.print(a+" ");
//            }
//            System.out.println();

            int stack[] = new int[100001];
            Arrays.fill(stack, Integer.MAX_VALUE);
            int max  = -1;
            for(int i = 0;i<n;i++) {
                int num = arr[i];

                for(int j=0;j<100001;j++) {
                    if(stack[j]>num) {
                        stack[j] = num;
                        if(j>max) {
                            max = j;
                        }
                        break;
                    }
                }
            }
            System.out.print(max+1+" ");

            for(int i = 0;i<=max;i++) {
                System.out.print(stack[i]+" ");
            }
            System.out.println();
        }
    }
}
