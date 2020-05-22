package Leet;

import java.util.Stack;

class L25Node {
    int data;
    L25Node next;

    L25Node(int data){
        this.data = data;
        this.next = null;
    }

    void add(L25Node head, L25Node newNode) {

        L25Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }


    void print(L25Node head) {
        L25Node temp = head;

        while(temp!=null) {
            System.out.println(temp.data);;
            temp = temp.next;
        }
    }
}
public class L25 {
    public static void main(String[] args) {
        new L25().run();
    }

    L25Node list;
    private void run() {

        int k = 1;
        list = new L25Node(1);
        L25Node head = list;

        list.add(head, new L25Node(2));
        list.add(head, new L25Node(3));
        list.add(head, new L25Node(4));
        list.add(head, new L25Node(5));

        //list.print(head);

        head = reverseInGrp(head, k);
        list.print(head);
    }

    private L25Node reverseInGrp(L25Node head, int k) {
        int len = 0;
        L25Node temp = head;
        while(temp!=null) {
            temp = temp.next;
            len++;
        }
        Stack<L25Node> stack = new Stack<>();

        int i = 0;
        temp = head;
        head = null;
        while(stack.size()<k){
            L25Node newNode = temp;
            temp = temp.next;
            newNode.next = null;
            stack.push(newNode);
            i++;
        }
        L25Node last = null;
        if(head == null){
            head = stack.pop();
            last = head;
        }
        while(!stack.isEmpty()){
            last.next = stack.pop();
            last = last.next;
        }

        while(true) {
            if(i+k>len) {
                break;
            }
            while(stack.size()<k && temp!=null) {
                L25Node newNode = temp;
                temp = temp.next;
                newNode.next = null;
                stack.push(newNode);
                i++;
            }

            while(!stack.isEmpty()) {
                last.next = stack.pop();
                last = last.next;
            }
        }
        if(temp!=null) {
            last.next = temp;
        }
        return head;

    }
}
