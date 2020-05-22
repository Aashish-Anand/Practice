package Leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L18 {
    public static void main(String[] args) throws IOException {
        new L18().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(reader.readLine());

        String s[] = reader.readLine().split(" ");

        int arr[] = new int[s.length];
        for(int i = 0;i<s.length;i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        findQuadruplets(arr, target);

    }

    private void findQuadruplets(int arr[], int target) {
        Arrays.sort(arr);

        int n = arr.length;

        TreeSet<String> set = new TreeSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for(int i = 0;i<n-3;i++) {
            for(int j = i+1;j<n-2;j++) {
                int first = j+1;
                int last = n-1;
                while(first<last) {
                    if (arr[i] + arr[j] + arr[first] + arr[last] == target) {
                        String str = arr[i] + ":" + arr[j] + ":" + arr[first] + ":" + arr[last];
                        if (!set.contains(str)) {
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[first]);
                            temp.add(arr[last]);
                            ans.add(temp);
                            temp = new ArrayList<>();
                            set.add(str);
                        }
                        first++;
                        last--;
                    } else if (arr[i] + arr[j] + arr[first] + arr[last]<target) {
                        first++;
                    }
                    else {
                        last--;
                    }
                }
            }
        }

//        System.out.println(ans.size());
//        for(List<Integer>itr : ans) {
//            System.out.println(itr);
//        }
    }
}
