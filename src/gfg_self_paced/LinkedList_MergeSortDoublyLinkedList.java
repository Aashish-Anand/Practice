package gfg_self_paced;

import linkedList.LinkedList;

import javax.xml.crypto.dom.DOMCryptoContext;

class DoubleyLinkedList {
    int data;
    DoubleyLinkedList prev;
    DoubleyLinkedList next;

    DoubleyLinkedList(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public void insert(DoubleyLinkedList head, int val) {
        DoubleyLinkedList curr = head;

        DoubleyLinkedList newElement = new DoubleyLinkedList(val);

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newElement;
        newElement.prev = curr;
    }

    public void print(DoubleyLinkedList head) {
        DoubleyLinkedList curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class LinkedList_MergeSortDoublyLinkedList {

    private static DoubleyLinkedList merge(DoubleyLinkedList head1, DoubleyLinkedList head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            head1.next = merge(head1.next, head2);
            DoubleyLinkedList temp = head1.next;
            temp.prev = head1;
            head1.prev = null;
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            DoubleyLinkedList temp = head2.next;
            temp.prev = head2;
            head2.prev = null;
            return head2;
        }
    }

    private static DoubleyLinkedList findMid(DoubleyLinkedList head) {
        DoubleyLinkedList slow = head;
        DoubleyLinkedList fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        DoubleyLinkedList temp = slow.next;
        slow.next = null;
        temp.prev = null;
        return temp;
    }

    private static DoubleyLinkedList mergeSort(DoubleyLinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleyLinkedList mid = findMid(head);

        return merge(mergeSort(head), mergeSort(mid));
    }

    public static void main(String[] args) {
        DoubleyLinkedList head = new DoubleyLinkedList(2);
        head.insert(head, 1);
        head.insert(head, 4);
        head.insert(head, 3);
        head.insert(head, 6);
        head.insert(head, 5);

        head = mergeSort(head);
        head.print(head);

    }
}
