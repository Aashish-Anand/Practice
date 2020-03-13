package HackerRank;

/**
 * Problem URL : https://www.hackerrank.com/challenges/chocolate-feast/problem
 */
public class chocolateFeast {

    /*
    n : money
    c : cost of chocolate
    m : wrapper exchange rate
     */
    private static int findChocolate(int n , int c, int m) {
        int chocolate = n/c;
        int wrapper = n/c;
        while(wrapper >= m) {
            int newChocolate = wrapper/m;
            wrapper -= newChocolate*m;
            wrapper += newChocolate;
            chocolate += newChocolate;
        }
        return chocolate;
    }
    public static void main(String[] args) {
        System.out.println(findChocolate(10,2,5));
    }
}
