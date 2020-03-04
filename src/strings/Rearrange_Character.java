package strings;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Given a string with repeated characters,
 * the task is to rearrange characters in a string 
 * so that no two adjacent characters are same.
 * 
 * Example :  aaabb  -  ababa
 */

public class Rearrange_Character {
	static class KeyComparator implements Comparator<Key> {

		@Override
		public int compare(Key k1, Key k2) {

			if (k1.freq < k2.freq) {
				return 1;
			} else if (k1.freq > k2.freq) {
				return -1;
			}
			return 0;
		}

	}

	static class Key {
		int freq;
		char ch;

		Key(int freq, char ch) {
			this.freq = freq;
			this.ch = ch;
		}
	}

	public static boolean checkIfRearranmentPossible(String str) {

		PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());

		int freqency[] = new int[26];

		int len = str.length();

		for (int i = 0; i < str.length(); i++) {
			freqency[str.charAt(i) - 'a']++;
		}

		for (char i = 'a'; i <= 'z'; i++) {
			int c = i - 'a';
			if (freqency[c] > 0) {
				pq.add(new Key(freqency[c], i));
			}
		}

		str = "";

		Key prev = new Key(-1, '#');

		while (!pq.isEmpty()) {
			Key p = pq.peek();
			pq.poll();

			str = str + p.ch;

			if (prev.freq > 0) {
				pq.add(prev);
			}

			p.freq--;
			prev = p;
		}

		if (str.length() != len) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int t = Integer.parseInt(s);
		while (t-- > 0) {
			String str = sc.nextLine();

			if (checkIfRearranmentPossible(str)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		}
		sc.close();
	}
}
