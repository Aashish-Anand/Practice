package Leet;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int arr[] = {3,2,6,5,0,3};

        int n = arr.length;

        int max = -1;
        int min = arr[0];

        int profit = 0;

        for(int i = 1;i<n;i++) {

            if(arr[i] > min) {
                max = arr[i];
            }
            if(max > min) {
                profit += (max - min);
            }
            if(arr[i]<min){
                min = arr[i];
            }
            else{
                min = max;
                max = -1;
            }
        }
        System.out.println(profit);
    }
}
