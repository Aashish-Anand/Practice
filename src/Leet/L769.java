package Leet;

public class L769 {
    public static void main(String[] args) {
        new L769().run();
    }

    private void run() {
        int arr[] = {1,0,2,4,3};

        int n = arr.length;

        int max = 0;
        int ans = 0;
        for(int i = 0;i<n;i++) {
            max = Math.max(max, arr[i]);
            if(max == i){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
