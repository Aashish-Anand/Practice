package chefTeCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class VIEW2001 {
    public static void main(String[] args) throws IOException {
        new VIEW2001().run();
    }

    private void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while(t-- > 0) {
            String arr[] = reader.readLine().split(" ");


            Double convertedValue = currencyConvertor(arr[0],arr[1]);

            DecimalFormat format = new DecimalFormat("0.##");

            System.out.println("$"+arr[0]+" CONVERTS TO "+format.format(convertedValue)+" "+arr[1]);


        }
    }

    private double currencyConvertor(String amount, String convertToThis) {

        int amountInNumber = Integer.parseInt(amount);

        switch (convertToThis){
            case "POUNDS" : return amountInNumber* 0.84;
            case "LIRA" : return amountInNumber * 2040;
            case "FRANCS" : return amountInNumber * 9.85;
            case "MARKS" : return amountInNumber * 3.23;
            default: return amountInNumber * 260;
        }
    }
}
