package gfg_self_paced;

import linkedList.LinkedList;

/*
Program to add 2 number inside the linked list
    eg : 1946 + 327 = 2273
 */
public class LinkedList_Add2Numbers {

    static int carry = 0;

    private static void addRemainingPart(LinkedList head1, LinkedList temp1) {
        if (head1.next != temp1) {
            addRemainingPart(head1.next, temp1);
        }
        int sum = head1.data + carry;
        head1.data = sum % 10;
        carry = sum / 10;
    }

    private static void addEqualParts(LinkedList temp1, LinkedList temp2) {
        if (temp1.next != null && temp2.next != null) {
            addEqualParts(temp1.next, temp2.next);
        }
        int sum = temp1.data + temp2.data + carry;
        temp1.data = sum % 10;
        carry = sum / 10;
    }

    private static LinkedList add2Numbers(LinkedList head1, LinkedList head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        /*
        Finding the length of each linked list
         */
        int len1 = 0;
        LinkedList temp1 = head1;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }

        int len2 = 0;
        LinkedList temp2 = head2;
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        if (len2 > len1) {
            LinkedList temp = head1;
            head1 = head2;
            head2 = temp;
        }
        temp1 = head1;
        temp2 = head2;

        int diff = Math.abs(len1 - len2);
        while (diff > 0) {
            temp1 = temp1.next;
            diff--;
        }

        addEqualParts(temp1, temp2);

        //head1.print(temp1);  // working fine
        if (head1 != temp1) {
            addRemainingPart(head1, temp1);
        }

        if (carry != 0) {
            /*
            This code will execute when we have a carry left from the previous evaluation
             */
            LinkedList carryNode = new LinkedList(carry);
            carryNode.next = head1;
            head1 = carryNode;
        }
        return head1;
    }

    public static void main(String[] args) {
        LinkedList head1 = new LinkedList(9);
        head1.insert(head1, 9);
        head1.insert(head1, 4);
        head1.insert(head1, 6);

        LinkedList head2 = new LinkedList(9);
        head2.insert(head2, 2);
        head2.insert(head2, 7);

        head1 = add2Numbers(head1, head2);
        head2.print(head1);
    }
}
