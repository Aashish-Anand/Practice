package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			sc.nextLine();

			Map<String, Integer> map = new HashMap<String, Integer>();

			int maxElement = 0;

			for (int j = 0; j < n; j++) {
				String str = sc.nextLine();

				String arr[] = str.split(" ");

				String itemName = arr[0];

				if (itemName.equals("top")) {
					Map<String, Integer> sorted = sortByValue(map);

					for (Map.Entry<String, Integer> m : sorted.entrySet()) {
						if (m.getValue() == maxElement) {
							System.out.print(m.getKey() + " ");
						} else {
							break;
						}
					}
					System.out.println();

				} else {
					int itemSold = Integer.parseInt(arr[1]);
					if (map.containsKey(itemName)) {
						int fromMap = map.get(itemName);
						if (maxElement < fromMap + itemSold) {
							maxElement = fromMap + itemSold;
						}
						map.put(itemName, fromMap + itemSold);
					} else {
						map.put(itemName, itemSold);
						if (maxElement < itemSold) {
							maxElement = itemSold;
						}
					}
				}

			}
		}
		sc.close();
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue() < o2.getValue()) {
					return 1;
				} else if (o1.getValue() > o2.getValue()) {
					return -1;
				}

				return o1.getKey().compareTo(o2.getKey());
			}

		});

		Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();

		for (Map.Entry<String, Integer> m : list) {
			sorted.put(m.getKey(), m.getValue());
		}

		return sorted;
	}

}
