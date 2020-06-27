package Leet;

public class L983 {
    public static void main(String[] args) {
        new L983().run();
    }

    private void run() {
        int days[] = {1, 4, 6, 7, 8, 20};
        int costs[] = {2, 7, 15};

        System.out.println(mincostTickets(days, costs));
    }

    private int mincostTickets(int days[], int costs[]) {
        // first we have to create the array of all the days i.e the travelling time frame
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        boolean travelling[] = new boolean[lastDay + 1];

        // mark all the traveling days
        for (int i = 0; i < days.length; i++) {
            int day = days[i];
            // marking it true
            travelling[day] = true;
        }

        for (int i = 1; i < lastDay + 1; i++) {
            // if we are not travelling on a day, then cost of travelling will be safe as day before
            if (!travelling[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            // now its time to check which ticket we need to purchase
            int price2 = dp[i - 1] + costs[0];  // if we buy ticket every day then total expenses will be
            // cost of previous day + 2

            int price7 = costs[1] + dp[Math.max(0, i - 7)];// if we buy ticket on weekly basis then total
            // expense will be cost of 7 day before + cost of weekly ticket because it will cover a
            // complete week

            int price30 = costs[2] + dp[Math.max(0, i - 30)]; // same as above but for monthly tickets

            dp[i] = Math.min(price2, Math.min(price7, price30));
        }

        return dp[lastDay];

    }
}
