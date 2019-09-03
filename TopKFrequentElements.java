package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements. Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * Explanation and Code from: https://medium.com/competitive-programming/leetcode-347-top-k-frequent-elements-274c42b5f69b
 */

public class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> ans = new LinkedList<>();
		
		if(nums.length == 1 && k == 1) {
            ans.add(nums[0]);
            return ans;
        } 
        else if(k <= 0) {
            return ans;
        }
		
		System.out.println(Arrays.toString(nums)+" k: "+k);
		
        int len = nums.length;
        int maxFreq = 0;
        
        // Algo - step 1:     
        Map<Integer, Integer> map = new HashMap<>();		//key - array number; value - frequency of array number
        
        for(int i=0; i<len; i++) {
        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" map: "+map+" maxFreq: "+maxFreq);
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            maxFreq = Math.max(maxFreq, map.get(nums[i]));
        }
        System.out.println("map: "+map+" maxFreq: "+maxFreq);
        
        // Algo - step 3 and 4: Create bucket of size of max Freq. 
        List<Integer>[] bucketList = new LinkedList[maxFreq+1];
        
        for(int i=0; i<= maxFreq; i++) {
            bucketList[i] = new LinkedList<>();
        }
        
        System.out.println("bucketList: "+bucketList);

        // Put elements in the bucket by iterating over the map
        for(Integer key: map.keySet()) {
            int freq = map.get(key);
            System.out.println("freq: "+freq+" key: "+key);
            bucketList[freq].add(key);
        }
        System.out.println("bucketList: "+bucketList);
        
        // Algo step 5:       
        for(int i=maxFreq; i>=0; i--) {
                
            List<Integer> currentList = bucketList[i];
            
            for(Integer key: currentList) {
                if(ans.size() < k) {
                    ans.add(key);   
                }
                else {
                    return ans;
                }
            }    
        }
        return ans;
    }

	//Refer this
	public static List<Integer> topKFrequent1(int[] nums, int k) {
		System.out.println(Arrays.toString(nums));
		
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		int maxFreq = 0;

		for(int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
			maxFreq = Math.max(maxFreq, frequencyMap.get(n));
		}

		System.out.println("frequencyMap: "+frequencyMap);
		List<Integer>[] bucket = new List[maxFreq + 1];
		
		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = maxFreq; pos >= 0 && res.size() < k; pos--) {
			System.out.println("pos: "+pos+" bucket[pos]: "+bucket[pos]);
			
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res.subList(0,k);
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3,3};
		int k = 2;
		
		System.out.println(topKFrequent1(nums, k));
	}

}
