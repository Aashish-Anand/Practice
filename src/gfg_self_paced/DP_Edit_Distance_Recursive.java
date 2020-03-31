package gfg_self_paced;

public class DP_Edit_Distance_Recursive {
    public static void main(String[] args) {
        new DP_Edit_Distance_Recursive().run();
    }

    private void run() {
        String str1 = "saturday";
        String str2 = "sunday";

        System.out.println(findOutTheTotalDistance(str1, str2, str1.length() - 1, str2.length() - 1));
    }

    private int findOutTheTotalDistance(String str1, String str2, int m, int n) {

        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (str1.charAt(m) == str2.charAt(n)) {
            return findOutTheTotalDistance(str1, str2, m - 1, n - 1);
        }

        return 1 + Math.min(findOutTheTotalDistance(str1, str2, m - 1, n - 1),
                Math.min(findOutTheTotalDistance(str1, str2, m, n - 1),
                        findOutTheTotalDistance(str1, str2, m - 1, n)));
    }
}
