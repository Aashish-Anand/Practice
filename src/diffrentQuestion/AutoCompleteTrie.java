package diffrentQuestion;

public class AutoCompleteTrie {

	static int Alphabet = 26;
	static class TrieNode {
		boolean isWordEnd;
		TrieNode children[] = new TrieNode[Alphabet];
		
		TrieNode() {
			isWordEnd = false;
			for(int i = 0;i<Alphabet;i++) {
				children[i] = null;
			}
		}
	}
	static TrieNode root;
	
	public static void insert(String str) {
		
		int index = 0;
		int len = str.length();
		
		TrieNode crawl = root;
		for(index = 0;index<len;index++) {
			int position = str.charAt(index) - 'a';
			if(crawl.children[position] == null) {
				crawl.children[position] = new TrieNode();
			}
			crawl = crawl.children[position];
		}
		crawl.isWordEnd = true;
	}
	
	public static boolean isLast(TrieNode crawl) {
		for(int i = 0;i<Alphabet;i++) {
			if(crawl.children[i] != null) {
				return false;
			}
		}
		return true;
	}
	public static void search(TrieNode crawl, String prefix) {
		if(crawl.isWordEnd) {
			System.out.println(prefix);
		}
		
		if(isLast(crawl)) {
			return;
		}
		
		for(int i = 0;i<Alphabet;i++) {
			
			if(crawl.children[i] != null) {
				String pre = prefix + (char)(97 + i);
				search(crawl.children[i], pre);
			}
		}
	}
	public static void searchRecursive(String query) {
		
		int len = query.length();
		int index = 0;
		TrieNode crawl = root;
		for(index = 0;index<len;index++) {
			int position = query.charAt(index) - 'a';
			if(crawl.children[position] == null) {
				return;
			}
			crawl = crawl.children[position];
		}
		
		boolean isWord = (crawl.isWordEnd == true);
		boolean islast = isLast(crawl);
		
		if(isWord && islast) {
			System.out.println(query);
			return;
		}	
		
		if(!islast) {
			String prefix = query;
			search(crawl, prefix);
			return;
		}
	}
	public static void main(String[] args) {
		
		root = new TrieNode();
		String string[] = {"hello","aashish","anand","helps","hel","helping"};
		
		for(int i = 0;i<string.length;i++) {
			insert(string[i]);
		}
		
		searchRecursive("he");
		
	}

}
