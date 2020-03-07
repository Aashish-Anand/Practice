package HackerRank;

import java.time.LocalDate;
import java.util.Scanner;

public class ToGetDayOutOfDate {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int date = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        LocalDate dated = LocalDate.of(year,month,date);
        System.out.print(dated.getDayOfWeek().toString());
    }
}
