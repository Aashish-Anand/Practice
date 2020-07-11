package Leet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class elements{
    int x;
    int y;
    int dist;

    elements(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class L864 {
    public static void main(String[] args) {
        new L864().run();
    }

    private void run() {
        String grid[] = {"@.a.#","###.#","b.A.B"};
        String grid1[] = {"...aA","..B#.","@...b"};
        System.out.println(shortestPathAllKeys(grid));
        System.out.println(shortestPathAllKeys(grid1));
        System.out.println(shortestPathAllKeys1(grid1));
    }

    private int shortestPathAllKeys(String grid[]) {
        int sx = 0;
        int sy = 0;

        int max = -1;
        for(int i = 0;i<grid.length;i++) {
            for(int j = 0;j<grid[i].length();j++) {
                if(grid[i].charAt(j) == '@') {
                    sx = i;
                    sy = j;
                }
                else{
                    if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f') {
                        max = Math.max(grid[i].charAt(j) - 'a'+1,-1);
                    }
                }
            }
        }
        //System.out.println(max);

        int n = grid.length;
        int m = grid[0].length();
        boolean vis[][] = new boolean[n][m];
        Queue<elements> q = new LinkedList<>();
        q.add(new elements(sx,sy,0));

        vis[sx][sy] = true;
        Set<Character> set = new HashSet<>();

        int totalDist = 0;
        int count = 0;
        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-->0) {
                elements e = q.poll();
                int move_x[] = {-1, 0, 1, 0};
                int move_y[] = {0, -1, 0, 1};
                if (grid[e.x].charAt(e.y) >= 'a' && grid[e.x].charAt(e.y) <= 'f') {
                    count++;
                    set.add(grid[e.x].charAt(e.y));
                    totalDist = dist;
                    if (count >= max) {
                        break;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int newx = e.x + move_x[i];
                    int newy = e.y + move_y[i];
                    if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] && grid[newx].charAt(newy) != '#') {
                        if (grid[newx].charAt(newy) >= 'A' && grid[newx].charAt(newy) <= 'F') {
                            if (set.contains(Character.toLowerCase(grid[newx].charAt(newy)))) {
                                vis[newx][newy] = true;
                                q.add(new elements(newx, newy, e.dist + 1));
                            }
                        } else {
                            vis[newx][newy] = true;
                            q.add(new elements(newx, newy, e.dist + 1));
                        }
                    }
                }
            }
            dist++;
        }

        return totalDist;
    }

    class State {
        int keys, i, j;
        State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }
    public int shortestPathAllKeys1(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        q.offer(start);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State cur = q.poll();
                if (cur.keys == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = cur.i + dir[0];
                    int j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a');
                        }
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
