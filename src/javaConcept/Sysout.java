package javaConcept;


import java.util.Arrays;
import java.util.LinkedList;

public class Sysout {
    public static void main(String[] args) {
        new Sysout().run();
    }
    private void run() {
        int i = 010;
        int j = 07;
        System.out.println(i);
        System.out.println(j);
        int mask = 0x000F;
        int value = 0x2222;
        System.out.println(mask +" "+ value);
        System.out.println(value & mask);
        LinkedList<String> ans = new LinkedList();
        String a = "adasda";
        char ch[] = a.toCharArray();
        Arrays.sort(ch);
        System.out.println(String.valueOf(ch));
        System.out.println();
        String anss = "abc";
        System.out.println(anss);
        anss = "adaacdad";
        System.out.println(anss);

    }
    /* Here is a comment **** */
}
