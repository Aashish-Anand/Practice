package Subsequence_And_Subarray;

public class powerfulNumberSubsequence {
    public static void main(String[] args) {
        new powerfulNumberSubsequence().run();
    }

    private void run() {
        int arr[] = { 6, 4, 10, 13, 9, 25 };

        int n = arr.length;

        System.out.println(findLength(arr,n));

    }

    private int findLength(int arr[], int n) {

        int count= 0;

        for(int i=0;i<n;i++) {
            if(isPowerful(arr[i])) {
                count++;
            }
        }

        return count;
    }

    private boolean isPowerful(int number) {

        if(number%2==0) {
            int count = 0;
            while(number%2==0) {
                count++;
                number/=2;
            }

            if(count == 1){
                return false;
            }
        }

        for(int i = 3;i<=Math.sqrt(number);i+=2) {

            int count = 0;
            while(number%i==0){
                count++;
                number/=i;
            }

            if(count==1){
                return false;
            }
        }

        return (number==1);
    }
}
