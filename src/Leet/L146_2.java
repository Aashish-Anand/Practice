package Leet;

import java.util.HashMap;
import java.util.Map;

class DEList {
    int key;
    int value;
    DEList prev;
    DEList next;

    DEList(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache1 {
    int capacity;
    Map<Integer, DEList> map = new HashMap<>();

    DEList first, last;  // first is the index of most recently used and last is for least recent used

    LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DEList element = map.get(key);
            moveToFirst(element);
            return element.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        /*
        Conditions to check
        1.  if it is present in map;
        2. if not then if size if full, then remove the last element
        3.  else add if
         */

        if (map.containsKey(key)) {
            DEList node = map.get(key);
            node.value = value;
            moveToFirst(node);
        } else if (map.size() == capacity) {
            DEList temp = last;
            last = last.prev;
            if(last == null){
                first = null;
            }
            else{
                last.next = null;
            }
            map.remove(temp.key);
            DEList node = new DEList(key, value);
            map.put(key, node);
            addToFirst(node);
        } else {
            DEList node = new DEList(key, value);
            map.put(key, node);
            addToFirst(node);
        }
    }

    private void addToFirst(DEList node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    private void moveToFirst(DEList node) {
        if (node == first) {
            first = node;
        } else if (last == node) {
            DEList temp = last;
            last = last.prev;
            last.next = null;

            first.prev = temp;
            temp.next = first;
            first = temp;


        } else {  // if element is in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev;

            first.prev = node;
            node.next = first;
            node.prev = null;
            first = node;
        }
    }
}

public class L146_2 {
    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));

//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
    }
}
