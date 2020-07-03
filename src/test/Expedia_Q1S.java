package test;

import java.util.HashMap;
import java.util.Map;

public class Expedia_Q1S {
    public static void main(String[] args) {
        new Expedia_Q1S().run();
    }

    private void run() {
        String arr[] = {"switch", "tv", "switch","tv","switch", "tv"};

        String result[] = new String[arr.length];
        Map<String, String> map = new HashMap<>();

        for(int i = 0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                String value = map.get(arr[i]);
                if(value.length()>arr[i].length()) {

                    String number = value.substring(arr[i].length());
                    if (!number.equals("")) {
                        int num = Integer.parseInt(number);
                        num += 1;

                        map.put(arr[i], arr[i] + num);
                        result[i] = arr[i] + num;
                    }
                }
                else{
                    map.put(arr[i], arr[i] + 1);
                    result[i] = arr[i] + 1;
                }
            }
            else{
                map.put(arr[i], arr[i]);
                result[i] = arr[i];
            }
        }

        for(String ans: result) {
            System.out.print(ans +" ");
        }
    }
}
