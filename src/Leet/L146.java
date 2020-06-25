package Leet;

import com.sun.imageio.plugins.common.I18N;

import java.util.*;

class LRUCache {
    int capacity;
    Map<Integer, Integer> hash = new LinkedHashMap<>();

    LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key) {
        if(hash.containsKey(key)){
            int value = hash.get(key);
            hash.remove(key);
            hash.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(hash.containsKey(key)){
            hash.remove(key);
            hash.put(key, value);
        }
        else if(hash.size()>=capacity){
            Iterator<Integer> itr = hash.keySet().iterator();
            int itemToRemove = itr.next();
            hash.remove(itemToRemove);
            hash.put(key,value);
        }
        else{
            hash.put(key, value);
        }
    }
}
public class L146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
}
