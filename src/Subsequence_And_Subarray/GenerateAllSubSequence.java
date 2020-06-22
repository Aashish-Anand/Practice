package Subsequence_And_Subarray;

public class GenerateAllSubSequence {
    public static void main(String[] args) {
        new GenerateAllSubSequence().run();
    }

    private void run() {
        int arr[] = {1, 2, 3};
        int n = arr.length;

        findAllSubs(arr,n);
    }

    private void findAllSubs(int arr[], int n) {
        int power = (int)Math.pow(2,n);

        for(int i = 1;i<power;i++) {
            System.out.println();
            for(int j = 0;j<n;j++) {
                if((i & (1<<j)) > 0) {
                    System.out.print(arr[j] +" ");
                }
            }
        }
    }
}
