package chefTeCode;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CVOTE {
    public static void main(String[] args) throws IOException {
        new CVOTE().run();
    }
    private void run() throws IOException {
        //Scanner sc = new Scanner(System.in);

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String s[] = sc.readLine().split(" ");

        int nChefs = Integer.parseInt(s[0]);
        int nEmails = Integer.parseInt(s[1]);

        Map<String, String> chefToCountry = new HashMap<>();
        for(int i = 0;i<nChefs;i++) {
            String str = sc.readLine();

            String arr[] = str.split(" ");
            chefToCountry.put(arr[0],arr[1]);
        }

        Map<String, Integer> winnerCountry = new TreeMap<>();
        Map<String, Integer> winnerChef = new TreeMap<>();

        for(int i = 0;i<nEmails;i++) {
            String chef = sc.readLine();

            String country = chefToCountry.get(chef);

            if(winnerCountry.containsKey(country)) {
                winnerCountry.put(country, winnerCountry.get(country)+1);
            }
            else{
                winnerCountry.put(country, 1);
            }

            if(winnerChef.containsKey(chef)){
                winnerChef.put(chef,winnerChef.get(chef)+1);
            }
            else{
                winnerChef.put(chef, 1);
            }
        }

        // Sorting both maps on the basis of value in decreasing order

        Comparator<Map.Entry<String, Integer>> comparatorValue = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int first = o1.getValue();
                int second = o2.getValue();
                if(first == second){
                    return o1.getKey().compareTo(o2.getKey());
                }
                else if( first < second){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };

        List<Map.Entry<String, Integer>> list = new ArrayList<>(winnerCountry.entrySet());
        Collections.sort(list, comparatorValue);

        winnerCountry = new LinkedHashMap<>();

        for(Map.Entry<String,Integer> items : list) {
            winnerCountry.put(items.getKey(), items.getValue());
        }

        list.clear();


        list = new ArrayList<>(winnerChef.entrySet());
        Collections.sort(list, comparatorValue);

        winnerChef = new LinkedHashMap<>();

        for(Map.Entry<String, Integer> items : list) {
            winnerChef.put(items.getKey(), items.getValue());
        }


        for(Map.Entry<String, Integer> entry : winnerCountry.entrySet()){
            System.out.println(entry.getKey());
            break;
        }
        for(Map.Entry<String, Integer> entry : winnerChef.entrySet()){
            System.out.println(entry.getKey());
            break;
        }
    }
}
