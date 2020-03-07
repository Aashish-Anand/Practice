package HackerRank;

public class gameOfTwoStacks {
    public static void main(String []args) {

        int a[] = {3,1,1,1,1};
        int b[] = {2,2,4,5};
        int x = 5;
        int sum = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        if(a[0]>x && b[0]>x) {
            System.out.println(0);
        }
        else {
            while(i<a.length && sum+a[i]<=x) {
                sum += a[i++];
            }

            count = i;

            while(i>0 && j < b.length) {
                sum += b[j++];

                while(i>0 && sum > x) {
                    i--;
                    sum -= a[i];
                }
                count = Math.max(count, i+j);
            }
            while(j<b.length && sum+b[j]<=x) {
                sum += b[j++];
            }

            System.out.println(Math.max(count, i+j));
        }
    }
}
