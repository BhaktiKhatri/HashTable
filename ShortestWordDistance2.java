package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 244. Shortest Word Distance II
 * https://leetcode.com/problems/shortest-word-distance-ii/description/
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many 
 * times with different parameters. How would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * Explanation and Code from: https://leetcode.com/problems/shortest-word-distance-ii/discuss/67028/Java-Solution-using-HashMap?page=1
 * LinkedIn
 * Medium
 */

public class ShortestWordDistance2 {
	
	public Map<String, List<Integer>> map;				//key-word; value-list of index of word in words[] array

	public ShortestWordDistance2(String[] words) {
		System.out.println("words: "+Arrays.toString(words));
		
	    map = new HashMap<String, List<Integer>>();
	    
	    for(int i=0; i<words.length; i++) {
	    	System.out.println("i: "+i+" words[i]: "+words[i]);
	    	
	        String w = words[i];
	        
	        System.out.println("map: "+map+" w: "+w);
	        
	        if(map.containsKey(w)) {
	            map.get(w).add(i);
	        }
	        else {
	            List<Integer> list = new ArrayList<Integer>();
	            list.add(i);
	            System.out.println("w: "+w+" list: "+list+" map: "+map);
	            map.put(w, list);
	        }
	        
	        System.out.println("map: "+map);
	    }
	}

	public int shortest(String word1, String word2) {
		System.out.println("word1: "+word1+" word2: "+word2);
		
	    List<Integer> list1 = map.get(word1);
	    List<Integer> list2 = map.get(word2);
	    int ret = Integer.MAX_VALUE;
	    
	    System.out.println("list1: "+list1+" list2: "+list2+" ret: "+ret);
	    
	    for(int i=0, j=0; i<list1.size() && j<list2.size();) {
	    	System.out.println("i: "+i+" j: "+j);
	    	
	        int index1 = list1.get(i);
	        int index2 = list2.get(j);
	        
	        System.out.println("index1: "+index1+" index2: "+index2);
	        
	        if(index1 < index2) {
	            ret = Math.min(ret, index2 - index1);
	            i++;
	        } 
	        else {
	            ret = Math.min(ret, index1 - index2);
	            j++;
	        }
	    }
	    System.out.println("ret: "+ret);
	    return ret;
	}

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistance2 word = new ShortestWordDistance2(words);
		
		String word1 = "makes";
		String word2 = "coding";
		
		System.out.println(word.shortest(word1, word2));
	}

}
