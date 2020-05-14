package CodeForces;

import java.util.*;


public class D642 {
    class Pairs implements Comparable {
        int start;
        int end;

        Pairs(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Pairs obj = (Pairs) o;
            return this.start - obj.start;
        }
    }

    public static void main(String[] args) {
        new D642().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];

            int diff = n - 1;
            TreeSet<Pairs> list = new TreeSet<>();

            Map<Integer, TreeSet<Pairs>> map = new TreeMap<>(Collections.reverseOrder());

            list.add(new Pairs(0, diff));

            // adding the first element in map i.e. n-1, pair : {0,n-1}
            map.put(diff, list);

            int i = 1;

            while (true) {
                for (Map.Entry<Integer, TreeSet<Pairs>> entry : map.entrySet()) {

                    // retriving the smallest value from the TreeSet
                    Pairs p = entry.getValue().pollFirst();

                    // finding the index where we have to insert element
                    int index = (p.end + p.start) / 2;
                    arr[index] = i;

                    i++;  // incrementing the element count

                    // if TreeSet is empty then remove the that entry from map
                    if (entry.getValue().size() == 0) {
                        map.remove(entry.getKey());
                    }

                    // find the next index and prev index of element that we already inserted
                    int prevIndex = index - 1;
                    int nextIndex = index + 1;

                    // logic for adding the prevIndex into the map only
                    if (prevIndex >= 0 && prevIndex < n) {

                        int newDiff = prevIndex - p.start;
                        if (map.containsKey(newDiff)) {
                            TreeSet<Pairs> pq = map.get(newDiff);
                            pq.add(new Pairs(p.start, prevIndex));
                            map.put(newDiff, pq);
                        } else {
                            TreeSet<Pairs> pq = new TreeSet<>();
                            pq.add(new Pairs(p.start, prevIndex));
                            map.put(newDiff, pq);
                        }
                    }

                    // logic for adding the nextIndex into the map only
                    if (nextIndex >= 0 && nextIndex < n) {
                        int newDiff = p.end - nextIndex;
                        if (map.containsKey(newDiff)) {
                            TreeSet<Pairs> pq = map.get(newDiff);
                            pq.add(new Pairs(nextIndex, p.end));
                            map.put(newDiff, pq);
                        } else {
                            TreeSet<Pairs> pq = new TreeSet<>();
                            pq.add(new Pairs(nextIndex, p.end));
                            map.put(newDiff, pq);
                        }
                    }
                    break;  // we are breaking as we have update the map
                }
                if (i == n + 1) {
                    break;
                }
            }

            for (i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
