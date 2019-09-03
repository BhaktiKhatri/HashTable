package HashTable;

import java.util.Arrays;
import java.util.Stack;

/*
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0]
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]
 * Explanation and Code from: https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack https://leetcode.com/problems/daily-temperatures/solution/
 * Time Complexity: O(N), Space Complexity: O(N)
 * Google
 * Medium
 */

public class DailyTemperatures {

	public static int[] dailyTemperatures(int[] temperatures) {
	    Stack<Integer> stack = new Stack<>();
	    int[] ret = new int[temperatures.length];
	    
	    System.out.println(Arrays.toString(temperatures));
	    
	    for(int i=0; i<temperatures.length; i++) {
	    	if(!stack.isEmpty())
	    		System.out.println("i: "+i+" temperatures[i]: "+temperatures[i]+" stack: "+stack+" temperatures[stack.peek()]: "+temperatures[stack.peek()]);
	    	else
	    		System.out.println("i: "+i+" temperatures[i]: "+temperatures[i]+" stack: "+stack);
	    	
	        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
	        	System.out.println("stack: "+stack);
	            int idx = stack.pop();
	            
	            System.out.println("idx: "+idx+" i-idx: "+(i-idx));
	            ret[idx] = i - idx;
	            System.out.println("ret[idx]: "+ret[idx]);
	        }
	        stack.push(i);
	        System.out.println("stack: "+stack);
	    }
	    System.out.println("ret: "+Arrays.toString(ret));
	    return ret;
	}
	
	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		
		temperatures = dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(temperatures));
	}

}
