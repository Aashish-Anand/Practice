package Leet;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class L438 {
    public static void main(String[] args) {
        new L438().run();
    }

    private void run() {
        String s = "cbaebabacd";
        String p = "bac";

        Arrays.sort(p.toCharArray());
        System.out.println(p);
    }
}
