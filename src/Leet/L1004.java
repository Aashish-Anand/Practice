package Leet;

public class L1004 {
    public static void main(String[] args) {
        new L1004().run();
    }

    private void run() {
        int arr[] = {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k = 0;

        System.out.println(longestOnes(arr, k));
        System.out.println(longestOnesApproach2(arr, k));
    }

    // this is a n^2 approach
    private int longestOnes(int arr[], int k) {
        int i = 0;
        int j = 0;

        int n = arr.length;
        int max = 0;
        while (i < n) {
            j = i;
            int tempAllowedChange = k;
            while (j < n && tempAllowedChange >= 0) {
                if (arr[j] == 0) {
                    tempAllowedChange--;
                    if (tempAllowedChange < 0) {
                        break;
                    }
                }
                j++;
            }
            max = Math.max(max, j - i);
            //System.out.print((j-i)+" ");
            i++;
        }
        return max;
    }

    private int longestOnesApproach2(int arr[], int k) {
        int i = 0;
        int j = 0;
        int tempAllowedOnes = k;
        int n = arr.length;
        int max = 0;
        while (j < n) {
            if(arr[j]==1){
                j++;
            }
            else if(arr[j]==0){
                tempAllowedOnes--;
                if(tempAllowedOnes<0) {
                    max = Math.max(max, j-i);
                    while(i<=j && tempAllowedOnes<0){
                        if(arr[i]==0){
                            tempAllowedOnes++;
                        }
                        i++;
                    }
                }
                j++;
            }
        }
        max = Math.max(max, j - i);
        return max;
    }
}
