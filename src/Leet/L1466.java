package Leet;

import java.util.ArrayList;

public class L1466 {
    public static void main(String[] args) {
        new L1466().run();
    }

    private void run(){
        int n = 6;
        int connections[][] = {{0,1},{1,3},{2,3},{4,0},{4,5}};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0;i<n;i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0;i<connections.length;i++) {
            list.get(connections[i][0]).add(connections[i][1]);
            list.get(connections[i][1]).add(-connections[i][0]);
        }


        boolean visited[] = new boolean[n];
        System.out.println(weWillDoTheDFS(list, 0, visited));
    }

    private int weWillDoTheDFS(ArrayList<ArrayList<Integer>> list, int startVertex, boolean[] visited) {

        visited[startVertex] = true;
        int numberOfDirectionToBeChanged = 0;
        for(int childVertex : list.get(startVertex)) {
            if(!visited[Math.abs(childVertex)]) {
                numberOfDirectionToBeChanged += weWillDoTheDFS(list,
                        Math.abs(childVertex), visited)+(childVertex>0?1
                        :0);
            }
        }
        return  numberOfDirectionToBeChanged;
    }
}
