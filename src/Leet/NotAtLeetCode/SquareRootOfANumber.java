package Leet.NotAtLeetCode;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        new SquareRootOfANumber().run();
    }
    private void run() {
        double n = 21;
        System.out.printf("%.5f",findSquareRoot(n));
    }
    private double findSquareRoot(double n) {
        double first = 0;
        for(double i = 0;i<n/2;i++) {
            if(i*i == n){
                return i;
            }

            else if(i*i > n){
                first = i;
                break;
            }
        }
        return findItNow(n, first-1, first);
    }

    private double findItNow(double n , double start, double end) {
        double mid = (start+end)/2;
        double mul = mid*mid;

        if(Math.abs(n-mul)<0.00001 || mul == n){
            return mid;
        }
        if(mul < n){
            return findItNow(n, mid, end);
        }
        else{
            return findItNow(n, start, mid);
        }
    }
}
