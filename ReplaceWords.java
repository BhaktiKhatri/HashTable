package HashTable;

import java.util.ArrayList;
import java.util.List;

/*
 * 648. Replace Words
 * https://leetcode.com/problems/replace-words/description/
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. 
 * For example, the root an, followed by other, which can form another word another.
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it.
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 * You need to output the sentence after the replacement.
 * Example 1: Input: dict = ["cat", "bat", "rat"]; sentence = "the cattle was rattled by the battery"; Output: "the cat was rat by the bat"
 * Note: The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 * Explanation and Code from: https://www.nowtoshare.com/en/Article/Index/70611 https://leetcode.com/problems/implement-trie-prefix-tree/solution/ https://leetcode.com/problems/replace-words/solution/
 * Time Complexity: O(N) where N is the length of the sentence. Every query of a word is in linear time
 * Space Complexity: O(N), the size of our trie
 * Uber
 * Medium
 */

public class ReplaceWords {
	
	class TrieNode {
	    TrieNode[] children;
	    String word;
	    
	    TrieNode() {
	        children = new TrieNode[26];
	    }
	}
	
	//Put all the roots in a trie (prefix tree). Then for any query word, we can find the smallest root that was a prefix in linear time

	public String replaceWords(List<String> dict, String sentence) {
		System.out.println("dict: "+dict+" sentence: "+sentence);
		
        TrieNode trie = new TrieNode();
        
        for(String root: dict) {
            
        	System.out.println("root: "+root);
        	
        	TrieNode node = trie;
            System.out.println("node: "+node);
            
            for(char letter: root.toCharArray()) {
            	System.out.println("letter: "+letter+" letter - 'a': "+(letter - 'a')+" node.children[letter - 'a']: "+node.children[letter - 'a']);
            	
                if(node.children[letter - 'a'] == null) {
                	node.children[letter - 'a'] = new TrieNode();
                }
                
                System.out.println("node.children[letter - 'a']: "+node.children[letter - 'a']);
                
                node = node.children[letter - 'a'];
                System.out.println("node: "+node);
            }
            System.out.println("node.word: "+node.word+" root: "+root);
            node.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for(String word: sentence.split(" ")) {
        	System.out.println("word: "+word+" ans: "+ans);
            
        	if(ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for(char letter: word.toCharArray()) {
            	System.out.println("letter: "+letter+" letter - 'a': "+(letter - 'a')+" cur.children[letter - 'a']: "+cur.children[letter - 'a']+" cur.word: "+cur.word);
                
            	if(cur.children[letter - 'a'] == null || cur.word != null) {
                    break;
            	}
            	
            	System.out.println("cur.children[letter - 'a']: "+cur.children[letter - 'a']);
            	cur = cur.children[letter - 'a'];
            	System.out.println("cur: "+cur);
            }
            System.out.println("cur.word: "+cur.word+" word: "+word);
            ans.append(cur.word != null ? cur.word : word);
        }
        System.out.println("ans: "+ans);
        return ans.toString();
    }
	
	public static void main(String[] args) {
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		
		String sentence = "the cattle was rattled by the battery";
		ReplaceWords replace = new ReplaceWords();
		
		sentence = replace.replaceWords(dict, sentence);
		System.out.println(sentence);
	}

}
