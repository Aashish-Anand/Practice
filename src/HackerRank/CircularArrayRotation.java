package HackerRank;

public class CircularArrayRotation {
    static int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
    static int[] circularArrayRotation(int[] arr, int k, int[] queries) {

        int len = arr.length;
        k = len - k%len;
        for(int i = 0;i<gcd(k,len);i++) {
            int temp = arr[i];
            int j = i;
            while(true) {
                int in = j+k;

                if(in>=len) {
                    in = in-len;
                }
                if(in == i) {
                    break;
                }
                arr[j] = arr[in];
                j = in;
            }
            arr[j] = temp;
        }

        int resultArr[] = new int[queries.length];
        for(int i = 0;i<queries.length;i++) {
            resultArr[i] = arr[queries[i]];
        }
        return resultArr;
    }


    public static void main(String [] args) {
        int sizeOfArray = 6;
        int arr[] = {1,2,3,4,5,6};
        int k = 50;
        int queries[] = {4,5,2,1};  // we need to find out the element present at particular index

        int result[] = circularArrayRotation(arr,k,queries);

        for(Integer i : result) {
            System.out.println(i);
        }
    }
}
