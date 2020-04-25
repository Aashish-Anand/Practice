package chefTeCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
/*
Half Correct
 */
class Pairs{
    int x;
    int y;
    Pairs(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
}
public class DPAIRS {
    public static void main(String[] args) {
        new DPAIRS().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[m];

        for(int i = 0;i<n;i++) {
            arr1[i] = sc.nextInt();
        }

        for(int j = 0;j<m;j++) {
            arr2[j] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();

        LinkedList<Pairs> pairSet = new LinkedList<>();
        boolean flag = false;
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                if(!set.contains(arr1[i]+arr2[j])) {
                    pairSet.add(new Pairs(i,j));
                    set.add(arr1[i]+arr2[j]);
                }
                if(set.size() == n+m-1) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        for(int i = 0;i<pairSet.size();i++) {
            System.out.println(pairSet.get(i).getX() +" "+ pairSet.get(i).getY());
        }

    }
}
