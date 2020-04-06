package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapPractice {
    public static void main(String[] args) {
        new MapPractice().run();
    }

    private void run() {
        Map<String, List<String>> map = new HashMap<>();
        //map.put("as", new ArrayList<String>("abc"));

        map.get("as").add("bcd");
        //map.put("a", map.get("a").add("Abs"));
        System.out.println(map.get("as"));
    }
}
