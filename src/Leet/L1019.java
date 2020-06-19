package Leet;

import Leet.GenericDataStructure.LinkedList;

import java.util.Stack;

class Pair {
    int index;
    int value;
    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex(){
        return index;
    }
    public int getValue() {
        return value;
    }
}
public class L1019 {
    public static void main(String[] args) {
        new L1019().run();
    }
    private void run() {
        //LinkedList list = new LinkedList(1);
        LinkedList list = new LinkedList();
//        list.add(list,new LinkedList(7));
//        list.add(list,new LinkedList(5));
//        list.add(list,new LinkedList(1));
//        list.add(list,new LinkedList(9));
//        list.add(list,new LinkedList(2));
//        list.add(list,new LinkedList(5));
//        list.add(list,new LinkedList(1));

        int[] arr = findNextGreatest(list);
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
    private int[] findNextGreatest(LinkedList list) {
        if(list== null){
            return new int[0];
        }

        LinkedList temp = list;

        int count = 0;
        while (temp!=null){
            temp=temp.next;
            count++;
        }
        int arr[] = new int[count];
        temp = list;

        Stack<Pair> stack = new Stack<>();
        int i = 0;
        stack.push(new Pair(i, temp.data));
        i++;
        temp = temp.next;

        while(temp!=null) {

            while(!stack.isEmpty() && stack.peek().getValue()<temp.data){
                Pair p = stack.pop();
                arr[p.getIndex()] = temp.data;
            }
            stack.push(new Pair(i, temp.data));

            temp = temp.next;
            i++;
        }

        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            arr[p.getIndex()] = 0;
        }

        return arr;
    }
}
