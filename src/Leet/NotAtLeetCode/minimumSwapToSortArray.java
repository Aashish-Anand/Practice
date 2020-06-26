package Leet.NotAtLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 * https://www.geeksforgeeks.org/minimum-swap-required-convert-binary-tree-binary-search-tree/
 *
 */
class pair1 {
    int value;
    int index;
    pair1(int value, int index){
        this.value = value;
        this.index = index;
    }
}


public class minimumSwapToSortArray {
    public static void main(String[] args) {
        new minimumSwapToSortArray().run();
    }

    private void run() {
        int arr[] = {8,6,9,5,10,7,11};
        System.out.println(findSwaps(arr));
    }
    private int findSwaps(int arr[]) {
        /*
        First we storing the array element and its corresponding index in a list
         */
        ArrayList<pair1> list = new ArrayList<>();

        int n = arr.length;
        for(int i = 0;i<n;i++) {
            list.add(new pair1(arr[i],i));
        }

        /*
        We sort the list according to the array value
         */
        Collections.sort(list, new Comparator<pair1>() {
            @Override
            public int compare(pair1 o1, pair1 o2) {
                if(o1.value>o2.value){
                    return 1;
                }
                else if(o1.value == o2.value){
                    return 0;
                }
                return -1;
            }
        });

//        list.forEach(a-> System.out.println(a.value));

        /*
        After sorting the we check each index if it is visited or not
        if visited that means we already traverse the index and it is considered a part of swap
        if not visited then we take the index and find the element store at that index using our list
        after that we take the index of the element and do the same thing until we fina a visited index
         */
        boolean visited[] = new boolean[n];
        int ans = 0;
        for(int i = 0;i<n;i++) {
            if(visited[i]){
                continue;
            }
            int j = i;
            int cycle = 0;

            while(!visited[j]) {
                visited[j] = true;
                cycle++;
                j = list.get(j).index;
            }

            if(cycle>0){
                ans+= (cycle-1);
            }
        }

        return ans;
    }
}
