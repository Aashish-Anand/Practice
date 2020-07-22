package Leet;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class L1481 {
    public static void main(String[] args) {
        new L1481().run();
    }

    private void run() {
        int arr[] = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts2(arr, k));
    }

    private int findLeastNumOfUniqueInts(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        LinkedList<Map.Entry<Integer, Integer>> ll = new LinkedList<>(map.entrySet());
        Collections.sort(ll, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        LinkedHashMap<Integer, Integer> lMap = new LinkedHashMap<>();

        for(Map.Entry<Integer, Integer> itr : ll){
            lMap.put(itr.getKey(), itr.getValue());
        }
        ll.clear();
        map.clear();

        int pos = 0;
        for(Map.Entry<Integer, Integer> itr : lMap.entrySet()){
            if(k==0){
                break;
            }
            if(itr.getValue()<=k){
                k -= itr.getValue();
                itr.setValue(0);
                pos++;
            }
            else{
                break;
            }
        }
        return lMap.size() - pos;
    }

    private int findLeastNumOfUniqueInts2(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<arr.length;i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> ll = new ArrayList<>(map.values());
        Collections.sort(ll);
        int i = 0;
        for(i = 0;i<ll.size();i++) {
            if(k == 0){
                break;
            }
            if(ll.get(i)<=k){
                k -= ll.get(i);
            }
            else{
                break;
            }
        }
        return ll.size() - i;
    }
}
