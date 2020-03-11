package HackerRank;

public class InsertionSort {
    private static void insertionSort(int arr[] ,int len) {

        for(int i = 0;i<len;i++) {
            int j = i-1;
            int temp = arr[i];
            while(j>=0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j -=1;
                printArray(arr, len);
                System.out.println();
            }
            arr[j+1] = temp;
        }
        printArray(arr, len);
    }

    private static void printArray(int arr[], int len) {
        for(int a : arr) {
            System.out.print(a +" ");
        }
    }
    public static void main(String []args) {
        int arr[] = {2,4,6,8,3};

        insertionSort(arr, arr.length);
    }
}
