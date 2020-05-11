package Subsequence_And_Subarray;

public class LongestSubsequenceWithFirstKAlphabetHaveSameFreq {
    public static void main(String[] args) {
        new LongestSubsequenceWithFirstKAlphabetHaveSameFreq().run();
    }

    private void run() {
        String str = "ACAABCCAB";
        int n = str.length();
        int k = 4;
        System.out.print(findlen(str, n, k));
    }

    private int findlen(String s, int n , int k) {
        int character[] = new int[26];

        for(int i = 0;i<n;i++) {
            character[s.charAt(i) - 'A']++;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i<k;i++) {
            if(character[i]<min) {
                min = character[i];
            }
        }
        for(int i = 0;i<k;i++) {
            character[i] = min;
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0;i<n;i++) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= ('A'+k)  && character[s.charAt(i)-'A']>0) {
                str.append(s.charAt(i));
                character[s.charAt(i)-'A']--;
            }
        }
        System.out.println(str);
        return str.length();
    }
}
