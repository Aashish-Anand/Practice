package Leet.NotAtLeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintAllSubArrayWithSum0 {
    public static void main(String[] args) {
        new PrintAllSubArrayWithSum0().run();
    }

    class Pair {
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private void run() {
        int arr[] = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        ArrayList<Pair> allSubArray = findAllSubArray(arr);
        allSubArray.forEach(a -> System.out.println("{ "+ a.x+" "+a.y+" }"));
    }

    private ArrayList<Pair> findAllSubArray(int arr[]){
        int n = arr.length;
        ArrayList<Pair> newList = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += arr[i];
            if(sum == 0){
                newList.add(new Pair(0,i));
            }
            if(!hash.containsKey(sum)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hash.put(sum,list);
            }
            else{
                ArrayList<Integer> getList = hash.get(sum);
                for(Integer a: getList){
                    newList.add(new Pair(a+1, i));
                }
                getList.add(i);
                hash.put(sum, getList);
            }
        }
        return newList;
    }
}
