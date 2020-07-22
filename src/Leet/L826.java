package Leet;

import java.util.*;

public class L826 {
    public static void main(String[] args) {
        new L826().run();
    }

    private void run() {
        int difficulty[] = {2,4,6,8,10,4};
        int profit[] = {10,20,30,40,50,100};
        int worker[] = {4,5,6,7};

        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    private int maxProfitAssignment(int []difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer>  map = new TreeMap<>();

        for(int i = 0;i<difficulty.length;i++) {
            int num = map.getOrDefault(difficulty[i],0);
            if(num < profit[i]){
                map.put(difficulty[i], profit[i]);
            }
        }

        int max = 0;;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
            }
            else{
                entry.setValue(max);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        int totalProfit = 0;

        for(int i= 0;i<worker.length;i++) {
            int currentWorker = worker[i];

            if(map.containsKey(worker[i])) {
                totalProfit+= map.get(worker[i]);
            }
            else {
                int expectedJob = findJob(list, currentWorker);
                if(expectedJob !=-1){
                    totalProfit+= map.get(expectedJob);
                }
            }
        }

        return totalProfit;
//        return 0;
    }

    private int findJob(ArrayList<Integer> list, int currentWorker) {

        if(currentWorker < list.get(0)){
            return -1;
        }
        if(currentWorker>list.get(list.size()-1)){
            return list.get(list.size()-1);
        }
        int l = 0;
        int r = list.size()-1;

        while(l<r) {
            int mid = l + (r-l)/2;
            if(list.get(mid)<currentWorker && list.get(mid+1)>currentWorker){
                return list.get(mid);
            }
            if(list.get(mid)>currentWorker && list.get(mid-1)<currentWorker){
                return list.get(mid-1);
            }
            if(list.get(mid)> currentWorker){
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return -1;
    }


}
