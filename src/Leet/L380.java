package Leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class L380 {
    public static void main(String[] args) {
        new L380().run();
    }

    HashMap<Integer, Integer> hash;
    LinkedList<Integer> arr;
    public L380() {
        hash = new HashMap<>();
        arr= new LinkedList<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(!hash.containsKey(val)) {
            arr.add(val);
            hash.put(val, arr.size()-1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hash.size() > 0 && hash.containsKey(val)){
            int index = hash.get(val);
            arr.set(index, null);
            hash.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(arr.size());
        System.out.println("Index : "+ index);
        while(arr.get(index)==null){
            index = random.nextInt(arr.size());
        }

        System.out.println("Index : "+ index);
        return arr.get(index);
    }

    private void run(){

        System.out.println(insert(1));
        System.out.println(remove(2));
        System.out.println(insert(2));
        System.out.println(getRandom());
        System.out.println(remove(1));
        System.out.println(insert(2));
        System.out.println(arr.size());
        for(Integer a: arr){
            System.out.println(a);
        }
        System.out.println(getRandom());
    }
}
