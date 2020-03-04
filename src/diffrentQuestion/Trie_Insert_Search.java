package diffrentQuestion;

public class Trie_Insert_Search {

	static final int Alphabet = 26;
	static class TrieNode{
		TrieNode children[] = new TrieNode[Alphabet];
		boolean isWordEnd;
		
		TrieNode() {
			isWordEnd = false;
			for(int i = 0;i<Alphabet;i++) {
				children[i] = null;
			}
		}
	}
	
	static TrieNode root;
	
	public static void insert(String str) {
		
		int length = str.length();
		int currentIndex = 0;
		
		TrieNode crawl = root;
		for(currentIndex=0; currentIndex<length ;currentIndex++) {
			int position = str.charAt(currentIndex)-'a';
			
			if(crawl.children[position] == null) {
				crawl.children[position] = new TrieNode();
			}
			
			crawl = crawl.children[position];
		}
		crawl.isWordEnd = true;
	}
	
	public static boolean search(String num) {
		int length = num.length();
		int currentIndex = 0;
		
		TrieNode crawl = root;
		
		for(currentIndex = 0; currentIndex<length; currentIndex++) {
			int position = num.charAt(currentIndex) - 'a';
			
			if(crawl.children[position] == null) {
				return false;
			}
			crawl = crawl.children[position];
		}
		
		return (crawl != null && crawl.isWordEnd);
	}
	
	public static void main(String[] args) {

		String array[] = {"aashish", "anand","mukhtar","ansari","mamta","godara","ruchi","kansal"};
		root = new TrieNode();
		
		for(int i = 0;i<array.length;i++) {
			insert(array[i]);
		}
		
		System.out.println(search("akshay"));
		
	}

}
