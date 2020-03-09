package HackerRank;

import java.util.ArrayList;
import java.util.Stack;

public class PoisonousPlants {

    private static int findPoisonousSolution1(int arr[], int len) {
        /*
        Solution 1 : using simple array iteration
         */
        int countDays = 0;
        boolean change = false;
        while(true) {
            int i = 0;
            change = false;
            int max = 0;
            for(i = 0;i<len;i++) {
                int temp = arr[i];
                if(temp>max && i!=0 && arr[i]!=-1) {
                    arr[i] = -1;
                    change = true;
                }
                if(temp!=-1) {
                    max = temp;
                }

            }
            if(!change) {
                break;
            }
            else{
                countDays++;
            }
        }
        return countDays;
    }

    private static int findPoisonousSolution2(int arr[], int len) {
        Stack<Integer> reverseStack = new Stack<>();
        Stack<Integer> simpleStack = new Stack<>();
        int countDays = 0;
        boolean change = false;
        boolean switchLogic = false;  // false = iterating in reverse array and true = iterating in simple array;

        for(int i = 0;i<len;i++) {
            reverseStack.push(arr[i]);
        }

        while(true) {
            if(switchLogic) {
                while(!simpleStack.isEmpty()) {
                    reverseStack.push(simpleStack.pop());
                }
                switchLogic = false;
            }
            else{
                change = false;
                int top = reverseStack.pop();
                while(!reverseStack.isEmpty()) {
                    if(top > reverseStack.peek()){
                        change = true;
                    }
                    else{
                        simpleStack.push(top);
                    }
                    top = reverseStack.pop();

                }
                simpleStack.push(top);
                switchLogic = true;
            }
            if(!change) {
                break;
            }
            else {
                countDays++;
            }
        }

        return countDays/2;
    }

    private static int findPoisonousSolution3(int arr[], int len) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<len;i++) {
            list.add(arr[i]);
        }
        boolean change = false;
        int countdays = 0;
        while(true) {
            ArrayList<Integer> newList = new ArrayList<>();
            //int prevSize = list.size();
            newList.add(list.get(0));
            for(int i = 1;i<list.size();i++) {
                if(list.get(i) <= list.get(i-1)) {
                    //list.remove(i);
                    newList.add(list.get(i));
                }

            }
            if(newList.equals(list)){
                break;
            }
            else{
                list.clear();
                list.addAll(newList);
                newList.clear();
                countdays++;
            }

         }
        return countdays;
    }
    public static void main(String []args) {
        int arr[] = {6,5,8,4,7,10,9};

        int len = arr.length;

        //System.out.println(findPoisonousSolution1(arr, len));
        //System.out.println(findPoisonousSolution2(arr, len));
        System.out.println(findPoisonousSolution3(arr, len));
    }
}
