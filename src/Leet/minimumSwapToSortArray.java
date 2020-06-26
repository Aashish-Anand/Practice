package Leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        ArrayList<pair1> list = new ArrayList<>();

        int n = arr.length;
        for(int i = 0;i<n;i++) {
            list.add(new pair1(arr[i],i));
        }

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
