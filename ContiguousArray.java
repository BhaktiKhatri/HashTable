package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/description/
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Example 1: Input: [0,1]; Output: 2; Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2: Input: [0,1,0] Output: 2; Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 * Explanation and Code from: #Approach3 https://leetcode.com/problems/contiguous-array/solution/
 * Also refer Approach2 for understanding
 * Time complexity: O(n); The entire array is traversed only once.
 * Space complexity: O(n); Maximum size of the HashMap map will be n, if all the elements are either 1 or 0.
 * Facebook
 * Medium
 */

public class ContiguousArray {

	/*
	 * we make use of a HashMap map to store the entries in the form of (index, count). We make an entry for a count in the map whenever the count is
	 * encountered first, and later on use the corresponding index to find the length of the largest subarray with equal no. of zeros and ones when the 
	 * same count is encountered again.
	 */
	
	public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();	//key - count; value - index
        map.put(0, -1);
        int maxlen = 0;
        int count = 0;
        
        System.out.println("nums: "+Arrays.toString(nums));
        System.out.println("map: "+map);
        
        for(int i=0; i<nums.length; i++) {
            
        	System.out.println("i: "+i+" nums[i]: "+nums[i]+" count: "+count);
        	count = count + (nums[i] == 1 ? 1 : -1);
            
        	System.out.println("map: "+map+" count: "+count);
        	
        	if(map.containsKey(count)) {
        		System.out.println("maxlen: "+maxlen+" i: "+i+" map.get(count): "+map.get(count));
                maxlen = Math.max(maxlen, i - map.get(count));
                System.out.println("maxlen: "+maxlen);
            }
        	else {
        		System.out.println("i: "+i+" count: "+count);
                map.put(count, i);
                System.out.println("map: "+map);
            }
        }

        System.out.println("maxlen: "+maxlen);
        
        return maxlen;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,0,1,1,0};
		
		System.out.println(findMaxLength(nums));		
	}

}
