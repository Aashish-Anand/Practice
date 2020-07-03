package Leet;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javaConcept.ListToMap;

import java.util.*;

class myPairs {
    int data1;
    int data2;
    myPairs(int data1, int data2){
        this.data1 = data1;
        this.data2 = data2;
    }

    public int getData1() {
        return data1;
    }

    public int getData2() {
        return data2;
    }
}
public class L373 {
    public static void main(String[] args) {
        new L373().run();
    }
    private void run() {
        int nums1[] = {0,0,0,0,0,2,2,2,2};
        int nums2[] = {-3,22,35,56,76};
        int k = 22;
        List<List<Integer>> answer = kSmallestPairs(nums1,nums2, k);
        answer.forEach(a-> a.forEach(ele -> System.out.println(ele)));
    }

    private List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<myPairs> pq = new PriorityQueue<>(new Comparator<myPairs>() {
            @Override
            public int compare(myPairs o1, myPairs o2) {
                return (o2.data2+o2.data1) - (o1.data2+o1.data1);
            }
        });

        boolean flag = false;
        for(int i = 0;i<nums1.length;i++) {
            for (int j = 0;j<nums2.length;j++) {
                if(i==6){
                    System.out.println();
                }
                myPairs my = new myPairs(nums1[i], nums2[j]);
                if(pq.size()<k){
                    pq.add(my);
                }
                else{
                    myPairs getTop = pq.peek();
                    if(getTop.data1+getTop.data2 > nums1[i]+ nums2[j]) {
                        pq.poll();
                        pq.add(new myPairs(nums1[i], nums2[j]));
                    }
                }
            }
            if(flag){
                break;
            }
        }
        List<List<Integer>> answer = new LinkedList<>();

        while (!pq.isEmpty()) {
            myPairs temp = pq.poll();
            List<Integer> ll = new LinkedList<>();
            ll.add(temp.data1);
            ll.add(temp.data2);
            answer.add(ll);
        }
        return answer;
    }
}
