package Leet;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class L295 {
    public static void main(String[] args) {
        new L295().run();
    }
    PriorityQueue<Integer> lowers;
    PriorityQueue<Integer> highers;
    L295() {
        lowers = new PriorityQueue<>(Collections.reverseOrder());
        highers = new PriorityQueue<>();
    }

    private void findIt(int num){
        if(lowers.size()==0 || lowers.peek()>num){
            lowers.add(num);
        }
        else {
            highers.add(num);
        }
        balanceIt();

    }
    private void balanceIt(){
        PriorityQueue<Integer> smaller = lowers.size()<highers.size()?lowers:highers;
        PriorityQueue<Integer> larger = lowers.size()<highers.size()?highers:lowers;

        if(larger.size()-smaller.size()>=2){
            smaller.add(larger.poll());
        }
    }

    private double medianIt() {
        PriorityQueue<Integer> smaller = lowers.size()<highers.size()?lowers:highers;
        PriorityQueue<Integer> larger = lowers.size()<highers.size()?highers:lowers;

        if(smaller.size()==larger.size()) {
            return (double)(smaller.peek()+larger.peek())/2;
        }
        else{
            return larger.peek();
        }
    }
    private void findAllMedian(int arr[]) {
        for(int i = 0;i<arr.length;i++) {
            findIt(arr[i]);
            String pattern = "#.#";
            DecimalFormat format = new DecimalFormat(pattern);
            System.out.println(format.format(medianIt()));
        }
    }

    private void run() {
        int[] arr = new int[]{5, 1500, 1000, 2000, 33242};

        findAllMedian(arr);
    }
}
