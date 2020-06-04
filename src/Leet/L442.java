package Leet;

public class L442 {
    public static void main(String[] args) {
        new L442().run();
    }
    private void run() {
       int arr[] = {4,3,2,7,8,2,3,1};

//        int arr[] = {1,2,3,4,5,6};
        int len = arr.length;

        for(int i = 0;i<len;i++) {
            int num = (arr[i]-1)%len;
            arr[num]+= len;
        }

        for(int i = 0;i<len;i++) {
            if((double)arr[i]/len>2) {
                System.out.print(i + " ");
            }
        }
    }
}
