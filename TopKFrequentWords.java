package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 692. Top K Frequent Words
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2; Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words. Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4; Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements. Input words contain only lowercase letters.
 * Follow up: Try to solve it in O(n log k) time and O(n) extra space.
 * Explanation and Code from: Approach #2 https://leetcode.com/problems/top-k-frequent-words/solution/
 * The size of the priority queue is k. Each insertion takes logk time and we are iterating over n distinct words in the worst case and inserting them into
 * the priority queue which makes the total runtime nlogk.
 * Time Complexity: O(Nlogk), where N is the length of words. We count the frequency of each word in O(N) time, then we add N words to the heap, each in
 * O(logk) time. Finally, we pop from the heap up to k times. As k ≤ N, this is O(Nlogk) in total
 * Space Complexity: O(N), the space used to store our count
 * Similar to Top K Frequent Elements, Sort Characters by frequency
 * https://www.mkyong.com/java8/java-8-lambda-comparator-example/
 */

public class TopKFrequentWords {

	//For Comparator refer https://www.mkyong.com/java8/java-8-lambda-comparator-example/
	//Count the frequency of each word, then add it to heap that stores the best k candidates. Here, "best" is defined with our custom ordering relation, 
	//which puts the worst candidates at the top of the heap. At the end, we pop off the heap up to k times and reverse the result so that the best
	//candidates are first.
	public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        
        System.out.println("words: "+Arrays.toString(words)+" k: "+k);
        
        for(String word: words) {
           count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("count: "+count);
        
        // (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        PriorityQueue<String> heap = new PriorityQueue<String>(words.length, new Comparator<String>() {
        	public int compare(String o1, String o2) {
        		System.out.println("o1: "+o1+" o2: "+o2+" count.get(o1): "+count.get(o1)+" count.get(o2): "+count.get(o2));
    			
        		if(count.get(o1) != count.get(o2)) {
    				System.out.println("count.get(o1) - count.get(o2): "+(count.get(o1) - count.get(o2)));
                    return count.get(o1) - count.get(o2);
                   //if this returns -1 then o1 comes before o2 in heap; e.g. o1-coding, o2-love gives -1 so heap:[coding, love]
                   //if this returns 1 then o2 comes before o1 in heap; e.g. o1-i, o2-coding gives 1 so heap:[coding, love, i]
    			}
                else {
                	System.out.println("o2.compareTo(o1): "+o2.compareTo(o1));
                    return o2.compareTo(o1);
                }
    		}
        });

        System.out.println("count: "+count);
        
        for(String word: count.keySet()) {
        	System.out.println("word: "+word+" heap: "+heap);
            heap.offer(word);
            
            System.out.println("word: "+word+" heap: "+heap+" heap.size(): "+heap.size()+" k: "+k);
            
            if(heap.size() > k) 
            	heap.poll();
        }

        List<String> ans = new ArrayList<String>();
        
        while(!heap.isEmpty()) {
        	System.out.println("heap: "+heap);
        	ans.add(heap.poll());
        	System.out.println("ans: "+ans);
        }
        
        Collections.reverse(ans);
        System.out.println("ans: "+ans);
        
        return ans;
    }
	
	public static List<String> topKFrequent1(String[] words, int k) {
		List<String> list = new ArrayList<>();
		
		if(words.length == 1 && k == 1) {
			list.add(words[0]);
			return list;
		}
		else if(k <= 0) {
			return list;
		}
		
		int len = words.length;// Algo - step 1
		int maxFreq = 0;
        Map<String, Integer> map = new HashMap<>();		//key - word; value - frequency of word
        
        for(int i=0; i<len; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(words[i]));
        }
        
        System.out.println("map: "+map+" maxFreq: "+maxFreq);
        
        List<String>[] bucketList = new List[maxFreq+1];
        
        for(String key : map.keySet()) {
            int freq = map.get(key);
            System.out.println("freq: "+freq+" key: "+key);
            
            if(bucketList[freq] == null) {
            	bucketList[freq] = new ArrayList<>();
            }
            bucketList[freq].add(key);
        }
        
        System.out.println("bucketList: "+bucketList);
        
        for(int i=maxFreq; i>=0; i--) {
            
            List<String> currentList = bucketList[i];
            if(currentList != null) {
	            for(String key: currentList) {
	                if(list.size() < k) {
	                    list.add(key);   
	                }
	                else {
	                    return list;
	                }
	            }
            }
        }
        
		return list;
	}
	
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		
		System.out.println(topKFrequent(words, k));
	}

}
