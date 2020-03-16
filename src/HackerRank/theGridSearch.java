package HackerRank;
/*
Problem Url : https://www.hackerrank.com/challenges/the-grid-search/problem

 The solution is not yet completed.
 */
public class theGridSearch {

    private static String search(String source[], String target[]) {
        int i = 0;
        int j = 0;
        while(i<source.length) {
            j = 0;
            int pos = 0;
            if(source[i].contains(target[j])){
                pos = source[i].indexOf(target[j]);
            }
            while( i<source.length && j< target.length && (source[i].indexOf(target[j])==pos)){
                i++;
                j++;
            }
            if(j == target.length) {
                return "YES";
            }
            i++;
        }
        return "NO";
    }

    public static void main(String[] args) {
//        String source[] = {"7283455864",
//                "6731158619",
//                "8988242643",
//                "3830589324",
//                "2229505813",
//                "5633845374",
//                "6473530293",
//                "7053106601",
//                "0834282956",
//                "4607924137"};

        String source[] = {"7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "6338453742",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137"};

        String target[] = {"9505",
                "3845",
                "3530"};
        System.out.println(search(source, target));
        //System.out.println(source[4].contains(target[0]));
    }
}
