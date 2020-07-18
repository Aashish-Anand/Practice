package Leet;

import java.util.*;

class element {
    int x, y;
    int dist;

    element(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDist() {
        return dist;
    }
}

public class L675 {
    public static void main(String[] args) {
        new L675().run();
    }

    private void run() {
        List<List<Integer>> forest = new LinkedList();
        forest.add(new ArrayList<>(Arrays.asList(1,2,3)));
        forest.add(new ArrayList<>(Arrays.asList(0,0,4)));
        forest.add(new ArrayList<>(Arrays.asList(7,6,5)));

//        forest.add(new ArrayList<>(Arrays.asList(0,0,0,3528,2256,9394,3153)));
//        forest.add(new ArrayList<>(Arrays.asList(8740,1758,6319,3400,4502,7475,6812)));
//        forest.add(new ArrayList<>(Arrays.asList(0,0,3079,6312,0,0,0)));
//        forest.add(new ArrayList<>(Arrays.asList(6828,0,0,0,0,0,8145)));
//        forest.add(new ArrayList<>(Arrays.asList(6964,4631,0,0,0,4811,0)));
//        forest.add(new ArrayList<>(Arrays.asList(0,0,0,0,9734,4696,4246)));
//        forest.add(new ArrayList<>(Arrays.asList(3413,8887,0,4766,0,0,0)));
//        forest.add(new ArrayList<>(Arrays.asList(7739,0,0,2920,0,5321,2250)));
//        forest.add(new ArrayList<>(Arrays.asList(3032,0,3015,0,3269,8582,0)));

        System.out.println(cutOffTree(forest));
    }

    // way 1 but not working for large inputs
//    private int cutOffTree(List<List<Integer>> forest) {
//
//        Queue<element> q = new LinkedList<>();
//        int dist = 0;
//        q.add(new element(0, 0, 0));
//        dist++;
//        int n = forest.size();
//        int m = forest.get(0).size();
//
//        int x_index[] = {-1, 1, 0, 0};
//        int y_index[] = {0, 0, 1, -1};
//
//        int min = Integer.MAX_VALUE;
//        int min_Index_x = -1;
//        int min_Index_y = -1;
//        int min_findingDistance = -1;
//        if(forest.get(0).get(0)>1){
//            min_Index_x = 0;
//            min_Index_y = 0;
//            min_findingDistance = 0;
//            min = forest.get(0).get(0);
//        }
//
//        // first prefetch all the non zero and none one numbers
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(int i = 0;i<n;i++){
//            for(int j = 0;j<m;j++) {
//                if(forest.get(i).get(j)>1){
//                    arr.add(forest.get(i).get(j));
//                }
//            }
//        }
//        Collections.sort(arr);
//
//        boolean visited[][] = new boolean[n][m];
//        visited[0][0] = true;
//
////        int largest = 0;
//
//        while (!q.isEmpty()) {
//            element e = q.poll();
//            int x = e.getX();
//            int y = e.getY();
//            int currDist = e.getDist();
//            for (int i = 0; i < 4; i++) {
//                int new_x = x + x_index[i];
//                int new_y = y + y_index[i];
//                if (isSafe(new_x, new_y, n, m) && !visited[new_x][new_y]) {
//                    if (forest.get(new_x).get(new_y) >= 1) {
//
//                        visited[new_x][new_y] = true;
//                        int num = forest.get(new_x).get(new_y);
//
////                        largest = num>largest?num:largest;
//
//                        q.add(new element(new_x, new_y, currDist + 1));
//                        if (num < min && num != 1) {
//                            min_Index_x = new_x;
//                            min_Index_y = new_y;
//                            min_findingDistance = currDist + 1;
//                            min = num;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(min_findingDistance + " " + min_Index_x + " " + min_Index_y);
//
//        if (min == Integer.MAX_VALUE) {
//            return -1;
//        }
//
//        q = new LinkedList<>();
//
//        int index = 1;
//        q.add(new element(min_Index_x, min_Index_y, min_findingDistance));
//        int nextElementToFind = arr.get(index);
//
//        boolean flag = false;
//        int maxDistance = 0;
//
//        while (!q.isEmpty()) {
//            element e = q.poll();
//            int x = e.getX();
//            int y = e.getY();
//            int currDist = e.getDist();
//            for (int i = 0; i < 4; i++) {
//                int new_x = x + x_index[i];
//                int new_y = y + y_index[i];
//                if (isSafe(new_x, new_y, n, m)) {
//                    int num = forest.get(new_x).get(new_y);
//                    if (num >= 1) {
//                        if (num == nextElementToFind) {
//
//                            if(index == arr.size()-1){
//                                flag = true;
//                                maxDistance = currDist+1;
//                                break;
//                            }
//                            nextElementToFind = arr.get(++index);
//                            q.clear();
//                            q.add(new element(new_x, new_y, currDist+1));
//                            break;
//                        }
//                        else {
//                            q.add(new element(new_x, new_y, currDist + 1));
//                        }
//                    }
//                }
//            }
//            if(flag){
//                break;
//            }
//        }
////        for(int i = 0;i<n;i++){
////            for(int j = 0;j<m;j++) {
////                largest = largest > forest.get(i).get(j) ? largest: forest.get(i).get(j);
////            }
////        }
//
//        if(nextElementToFind < arr.get(arr.size()-1)){
//            return -1;
//        }
//        return maxDistance;
//    }
//
//    private boolean isSafe(int new_x, int new_y, int n, int m) {
//        if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
//            return true;
//        }
//        return false;
//    }

    private int cutOffTree(List<List<Integer>> forests){

        int n = forests.size();
        int m = forests.get(0).size();

        // this list will contains all the tree indexes and the value of that tree
        List<element> ll = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                int value = forests.get(i).get(j);
                if(value>1){
                    ll.add(new element(i,j,value));
                }
            }
        }
        // sort the list wrt. the tree value as we need to cut smallest tree first
        Collections.sort(ll, Comparator.comparingInt(element::getDist));
//        for(int i = 0;i<ll.size();i++){
//            System.out.print(ll.get(i).getDist()+" ");
//        }
        int ans = 0;
        int sourcex = 0;
        int sourcey = 0;

        /**
         * here first we will find the distance of first tree from (0,0) once found
         * then we will find the second tree distance from first tree and so on.
         */
        for(element e : ll) {
            int distance = findDist(forests, sourcex, sourcey, e.getX(), e.getY());
            if(distance < 0){
                return -1;
            }
            ans += distance;
            sourcex = e.getX();
            sourcey = e.getY();
        }
        return ans;
    }

    private int findDist(List<List<Integer>> forest, int sourcex, int sourcey, int destinationx,
                         int destinationy) {

        int nextX[] = {-1,1,0,0};
        int nextY[] = {0,0,-1,1};
        Queue<element> q = new LinkedList<>();
        q.add(new element(sourcex,sourcey,0));
        int n = forest.size();
        int m = forest.get(0).size();

        boolean visited[][]  = new boolean[n][m];
        visited[sourcex][sourcey] = true;
        while(!q.isEmpty()){
            element e = q.poll();
            if(e.getX() == destinationx && e.getY() == destinationy){
                return e.getDist();
            }
            for(int i = 0;i<4;i++) {
                int newx = e.getX()+ nextX[i];
                int newy = e.getY() + nextY[i];
                if(isSafe(newx,newy, n,m) && !visited[newx][newy] && forest.get(newx).get(newy)>0){
                    visited[newx][newy] = true;
                    q.add(new element(newx,newy, e.getDist()+1));
                }
            }
        }
        return -1;
    }
    private boolean isSafe(int new_x, int new_y, int n, int m) {
        if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
            return true;
        }
        return false;
    }
}
