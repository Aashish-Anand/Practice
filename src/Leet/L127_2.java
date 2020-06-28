package Leet;

import java.util.*;

// this is the bidirectional BFS solution
// Bidirectional BFS means we are applying bfs from source node and target node
// and then try to find the solution
class node {
    String word;
    int len;
    node(String word, int len) {
        this.len = len;
        this.word = word;
    }
}
public class L127_2 {
    public static void main(String[] args) {
        new L127_2().run();
    }

    private void run() {
        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));
        //System.out.println(list.size());

        String beginWord = "hit";
        String endWord = "dog";

        System.out.println(ladderLength(beginWord, endWord, list));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // queue to store the current word
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();

        // hash map is just to check if this element is already visited or not
        HashMap<String, Integer> h1 = new HashMap<>();
        HashMap<String, Integer> h2 = new HashMap<>();

        node n1 = new node(beginWord, 1);
        node n2 = new node(endWord,1);

        q1.add(n1);
        q2.add(n2);

        h1.put(beginWord, 1);
        h2.put(endWord,1);

        while(q1.size()>0 && q2.size()>0) {

            node getNode1 = q1.poll();
            node getNode2 = q2.poll();

            for(int i = 0;i<wordList.size();i++) {
                if(isAdjacent(getNode1.word,wordList.get(i))&& !h1.containsKey(wordList.get(i))) {

                    node n = new node(wordList.get(i), getNode1.len+1);
                    q1.add(n);
                    h1.put(wordList.get(i), getNode1.len+1);

                    if(wordList.get(i).equals(endWord)){
                        return n.len;
                    }

                    if(h2.containsKey(n.word)){
                        return  n.len + h2.get(n.word)-1;
                    }
                }
            }

            for(int i = 0;i<wordList.size();i++){
                if(isAdjacent(getNode2.word, wordList.get(i)) && !h2.containsKey(wordList.get(i))) {
                    node n = new node(wordList.get(i), getNode2.len+1);
                    q2.add(n);
                    h2.put(wordList.get(i), getNode2.len+1);

                    if(n.word.equals(endWord)){
                        return n.len;
                    }

                    if(h1.containsKey(n.word)){
                        return n.len+ h1.get(n.word)-1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isAdjacent(String s1, String s2){
        int count = 0;

        for(int i = 0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
}
