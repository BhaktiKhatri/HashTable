package HashTable;

import java.util.ArrayList;
import java.util.List;

class TrieNode {

	public String trieWord;
	
    // R links to node children
    public TrieNode[] links;

    public final int R = 26;

    public boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {
	
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word, TrieNode trie) {
        TrieNode node = trie;
        for(int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.trieWord = word;
        node.setEnd();
    }
    
    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word, TrieNode cur) {
        TrieNode node = cur;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }
    
	public String replaceWords(List<String> dict, String sentence) {
		TrieNode trie = new TrieNode();
		
		for(String root: dict) {
			insert(root, trie);
		}
		
		StringBuilder ans = new StringBuilder();
		
		for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");
		
            TrieNode cur = trie;
            
            for (char letter: word.toCharArray()) {
                if (cur.links[letter - 'a'] == null || cur.trieWord != null)
                    break;
                cur = cur.links[letter - 'a'];
            }
            ans.append(cur.trieWord != null ? cur.trieWord : word);
		}
		
		return ans.toString();
	}
	
	public static void main(String[] args) {
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		
		String sentence = "the cattle was rattled by the battery";
		
		Trie replace = new Trie();
		
		sentence = replace.replaceWords(dict, sentence);
		
		System.out.println(sentence);
	}
}
