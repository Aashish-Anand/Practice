package Leet;

public class L28 {
    public static void main(String[] args) {
        new L28().run();
    }

    private void run() {
        System.out.println(strStr("mississippi", "issip"));
    }
    private int strStr(String haystack, String needle) {

        int len = needle.length();
        if(haystack.length() == 0 && needle.length()==0) {
            return 0;
        }
        if(haystack.length() == 0 ) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }

        int needleLength = needle.length();
        int haystackLength = haystack.length();
        int j= 0;
        for(int i = 0;i<haystackLength;i++) {
            int k = i;
            while(k<haystackLength && j<needleLength &&haystack.charAt(k) == needle.charAt(j)) {
                if(j == needleLength-1){
                    return k - needleLength +1;
                }
                k++;
                j++;
            }
            j=0;
        }
        return -1;
    }
}
