package HackerRank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Currency {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double curr = sc.nextDouble();
        sc.close();

        Locale indiaLocale = new Locale("en", "IN");

        /* Create NumberFormats using Locales */
        NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        /* Print output */
        System.out.println("US: "     + us.format(curr));
        System.out.println("India: "  + india.format(curr));
        System.out.println("China: "  + china.format(curr));
        System.out.println("France: " + france.format(curr));
    }
}
