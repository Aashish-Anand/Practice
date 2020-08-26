package Test1;

import java.util.*;
public class LinkedList {
    public static void main(String[] args) {

        LinkedList l = new LinkedList();
        l.start();
        System.out.println();

        char a[] = new char[10];
        for(int i = 0;i<10;++i) {
            a[i] = '1';
            System.out.println(a[i]+"");
            i++;
        }
    }
    void start() {
        long a[] = {3,4,5};
        long b[] = fix(a);
        System.out.println(a[0]+a[1]+a[2]+" ");
        System.out.println(b[0]+b[1]+b[2]);
    }
    long[] fix(long a2[]) {
        a2[1] = 7;
        return a2;
    }
}
