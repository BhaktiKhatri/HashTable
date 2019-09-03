package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 676. Implement Magic Dictionary
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 * Implement a magic directory with buildDict, and search methods.
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified
 * word is in the dictionary you just built.
 * Example 1: Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * Note: You may assume that all the inputs are consist of lowercase letters a-z.
 * For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
 * Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. 
 * Please see here for more details.
 * Explanation and Code from: @Yang_BU https://leetcode.com/problems/implement-magic-dictionary/discuss/107446/Easy-14-lines-Java-solution-HashMap
 * Google
 * Medium
 */

public class MagicDictionary {

    static Map<String, Character> map = new HashMap<>();  

    /** Build a dictionary through a list of words */
    public static void buildDict(String[] dict) {
    	System.out.println("dict: "+Arrays.toString(dict));
    	
        for(String s: dict) {
        	System.out.println("s: "+s);
        	
            StringBuilder sb = new StringBuilder(s);
        	
            for(int i=0; i<sb.length(); i++) {
                sb.setCharAt(i, '*');
            	System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" sb: "+sb+" map: "+map);
                
                map.put(sb.toString(), map.containsKey(sb.toString()) ? '*' : s.charAt(i));
                System.out.println("map: "+map+" sb: "+sb);
                
                sb.setCharAt(i, s.charAt(i));
                System.out.println("sb: "+sb);
            }
        }
    }
    
    /** Returns if there is an\y word in the trie that equals to the given word after modifying exactly one character */
    public static boolean search(String word) {
    	System.out.println("word: "+word);
    	
    	for(String key: map.keySet()) {
    		if(word.length() != key.length()) {
    			return false;
    		}
    		break;
    	}
    	
    	StringBuilder sb = new StringBuilder(word);
        
        for(int i=0; i<sb.length(); i++) {
        	System.out.println("i: "+i+" sb: "+sb);
            
        	sb.setCharAt(i, '*');
            System.out.println("sb: "+sb+" map: "+map+" map.get(sb.toString()): "+map.get(sb.toString())+" word.charAt(i): "+word.charAt(i));
            
            if(map.containsKey(sb.toString()) && word.charAt(i) != map.get(sb.toString())) { 
            	return true;
            }
            
            System.out.println("i: "+i+" word.charAt(i): "+word.charAt(i)+" sb: "+sb);
            sb.setCharAt(i, word.charAt(i));
            
            System.out.println("sb: "+sb);
        }
        return false;
    }
	
	public static void main(String[] args) {
		String[] dict = {"hello","hallo"};
		
		buildDict(dict);
		
		System.out.println("map: "+map);
		
		System.out.println(search("hallo"));
	}
}
	