package HashTable;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 325. Maximum Size Subarray Sum Equals k
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * Example 2: Given nums = [-2, -1, 2, 1], k = 1, return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * Follow Up: Can you do it in O(n) time?
 * Explanation and Code from: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77784/O(n)-super-clean-9-line-Java-solution-with-HashMap?page=2
 * http://letstalkalgorithms.com/maximum-size-subarray-sum-equals-k-leetcode/
 * We traverse through the whole array once and caclulate sum and max index, so the time complexity is O(n), space complexity is O(n) since we use a map
 * Facebook, Palantir
 * Medium
 */

public class MaximumSizeSubarraySumEqualsK {

	/*
	 	The HashMap stores the sum of all elements before index i as key, and i as value. For each i, check not only the current sum but also
	 	(currentSum - previousSum) to see if there is any that equals k, and update max length.
	 */
	public static int maxSubArrayLen(int[] nums, int k) {
	    int sum = 0;
	    int max = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();		//key-sum upto index i; value-index of sum
	    
	    System.out.println("nums: "+Arrays.toString(nums)+" k: "+k);
	    
	    for(int i=0; i<nums.length; i++) {
	        System.out.println("i: "+i+" nums[i]: "+nums[i]+" sum: "+sum);
	    	
	    	sum = sum + nums[i];
	    	System.out.println("sum: "+sum+" k: "+k+" max: "+max);
	        
	        if(sum == k) {
	        	max = i + 1;
	        }
	        else if(map.containsKey(sum - k)) { 
	        	System.out.println("i: "+i+" sum: "+sum+" sum-k: "+(sum-k)+" max: "+max);
	        	max = Math.max(max, i - map.get(sum - k));
	        }
	        System.out.println("max: "+max);
	        
	        if(!map.containsKey(sum)) { 
	        	map.put(sum, i);
	        }
	        
	        System.out.println("map: "+map);
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, -1, 5, -2, 3, 1, -1, 1, 1, 1}; 
		int k = 3;
		
		System.out.println(maxSubArrayLen(nums, k));
	}

}
