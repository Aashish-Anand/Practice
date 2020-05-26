package Leet;

public class L26 {
    public static void main(String[] args) {
        new L26().run();
    }

    private void run() {
        int arr[] = {0,0};

        int n = arr.length;

        int i = 0, j = i+1;

        while(j<n) {
            while( j<n && arr[j]==arr[i] ){
                j++;
            }
            if(j<n) {
                arr[++i] = arr[j];
            }
        }
        for(Integer a: arr) {
            System.out.print(a+" ");
        }
    }
}
