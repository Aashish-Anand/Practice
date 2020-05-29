package Leet;

public class L338 {
    public static void main(String[] args) {
        new L338().run();
    }

    private void run() {
        int num = 1;

        int arr[] = new int[num+1];

        arr[0] = 0;

        for(int i = 1;i<=num;i++) {
            arr[i] = arr[i&(i-1)]+1;
        }

        for(int i = 0;i<arr.length;i++) {
            System.out.print(arr[i] +" ");
        }
    }
}
