package Leet;

public class L209 {
    public static void main(String[] args) {
        new L209().run();
    }

    private void run() {
        int arr[] = {2, 3, 1, 2, 4, 3};
        int n = arr.length;
        int s = 1;

        int size = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int sum = 0;
        while(j<n){
            sum += arr[j];
            if(sum>=s){
                while(i<=j && sum >= s){
                    size = Math.min(size, j-i+1);
                    sum -= arr[i];
                    i++;
                }
            }
            j++;
        }
        System.out.println(size == Integer.MAX_VALUE? 0: size);
    }
}
