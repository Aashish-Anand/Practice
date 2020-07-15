package Leet;

import java.util.Arrays;

public class L201 {
    public static void main(String[] args) {
        new L201().run();
    }

    private void run() {
        int m = 0;
        int n = 2147483647;
        System.out.println(rangeBitwiseAnd(m, n));
        System.out.println(rangeBitwiseAnd2(m, n));
    }

    private int rangeBitwiseAnd(int m, int n) {

        if (m == 0) {
            return 0;
        }
        if (m == n) {
            return m & n;
        }
        int mClone = m;
        int nClone = n;
        int mArray[] = new int[32];
        int nArray[] = new int[32];

        int i = 31;
        while (mClone > 0) {
            mArray[i] = mClone % 2;
            mClone /= 2;
            i--;
        }
        i = 31;
        while (nClone > 0) {
            nArray[i] = nClone % 2;
            nClone /= 2;
            i--;
        }
        i = 31;
        int diff = n - m;
        int powerOf2 = 0;
        int ans[] = new int[32];
        while (i >= 0) {
            if (diff > (int) Math.pow(2, powerOf2) - 1) {
                ans[i] = 0;
            } else {
                ans[i] = mArray[i] == 1 && nArray[i] == 1 ? 1 : 0;
            }
            powerOf2 += 1;
            i--;
        }

        int result = 0;
        powerOf2 = 31;
        for (i = 0; i < 32; i++) {
            if (ans[i] == 1) {
                result += Math.pow(2, powerOf2 - i);
            }
        }


        return result;
    }

    private int rangeBitwiseAnd2(int m, int n) {

        while (m < n) {
            n = n & (n - 1);
        }
        return m & n;
    }
}
