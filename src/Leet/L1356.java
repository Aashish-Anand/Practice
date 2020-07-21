package Leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L1356 {
    public static void main(String[] args) {
        new L1356().run();
    }

    private void run() {
        int arr[] = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        arr = sortByBits(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    class element {
        int value;
        int bits;

        element(int value, int bits) {
            this.value = value;
            this.bits = bits;
        }
    }

    private int[] sortByBits(int arr[]) {
        PriorityQueue<element> pq = new PriorityQueue<>(new Comparator<element>() {
            @Override
            public int compare(element o1, element o2) {
                if (o1.bits > o2.bits) {
                    return 1;
                }
                if (o1.bits == o2.bits) {
                    return o1.value - o2.value;
                }
                return o1.bits - o2.bits;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            pq.add(new element(arr[i], Integer.bitCount(arr[i])));
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.poll().value;
        }
        return arr;
    }

    /*
    Way 2 using quick sort
     */
    private int[] sortByBits2(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int p, int q) {
        if (p >= q) return;
        int pivotCount = Integer.bitCount(arr[q]);
        int i = p - 1;
        for (int j = p; j < q; j++) {
            int count = Integer.bitCount(arr[j]);
            if (count < pivotCount || (count == pivotCount && arr[j] < arr[q])) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, q, i);
        quickSort(arr, p, i - 1);
        quickSort(arr, i + 1, q);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
