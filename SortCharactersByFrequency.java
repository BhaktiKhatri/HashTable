package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1: Input:"tree"; Output:"eert"
 * Explanation:'e' appears twice while 'r' and 't' both appear once.So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2: Input:"cccaaa"; Output:"cccaaa"
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer. Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3: Input:"Aabb"; Output:"bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note that 'A' and 'a' are treated as two different characters.
 * Explanation and Code from: https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogn)-PriorityQueue-Solution-easy-to-understand
 * Google, Amazon
 * Medium
 */

public class SortCharactersByFrequency {

	/*
	 	The logic is very similar to NO.347 and here we just use a map a count and according to the frequency to put it into the right bucket. 
	 	Then we go through the bucket to get the most frequently character and append that to the final stringbuilder.
	 */
	public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();				//key-character; value-frequency of character
        System.out.println("s: "+s);
        
        for(char c: s.toCharArray()) {
        	System.out.println("map: "+map+" c: "+c+" map.get(c): "+map.get(c));
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] bucket = new List[s.length() + 1];
        
        for(char key: map.keySet()) {
        	System.out.println("map: "+map+" key: "+key+" map.get(key): "+map.get(key));
            int frequency = map.get(key);
            
            System.out.println("frequency: "+frequency+" bucket[frequency]: "+bucket[frequency]);
            
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(int pos=bucket.length-1; pos>=0; pos--) {
        	System.out.println("pos: "+pos+" bucket[pos]: "+bucket[pos]);
        	
            if(bucket[pos] != null) {
            	
            	for(char ch : bucket[pos]) {
                	System.out.println("ch: "+ch+" map.get(ch): "+map.get(ch));
                	cnt = pos;
                	while(cnt>0) {
                		sb.append(ch);
                		cnt--;
                	}
                	//for (int i=0; i<pos; i++) {
                    //}
                    System.out.println("sb: "+sb);
                }
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "tree";
		
		System.out.println(frequencySort(s));
	}

}