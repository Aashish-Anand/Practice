package Leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class L1358 {
    public static void main(String[] args) throws IOException {
        new L1358().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int n = s.length();
        int j = 0;
        int result = 0;

        while(true) {
            while (map.size() < 3 && i < n) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
                i++;
            }

            while (map.size() == 3) {
                result += n - i + 1;
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) <= 0) {
                    map.remove(s.charAt(j));
                }
                j++;
            }
            if(i>=n) {
                break;
            }
        }
        System.out.println(result);
    }
}
