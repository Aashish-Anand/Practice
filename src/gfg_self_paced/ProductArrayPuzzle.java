package gfg_self_paced;

public class ProductArrayPuzzle {
    public static void main(String[] args) {
        new ProductArrayPuzzle().run();
    }

    private void run() {
        int arr[] = {10, 3, 5, 6, 2};

        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0]=1;
        right[n-1] = 1;
        int mul = 1;
        for(int i = 1;i<n;i++) {
            mul *= arr[i-1];
            left[i] = mul;
        }
        mul = 1;

        for(int j = n-2;j>=0;j--) {
            mul *= arr[j+1];
            right[j] = mul;
        }

        for(int i = 0;i<n;i++) {
            System.out.print(left[i]* right[i] +" ");
        }

    }
}
