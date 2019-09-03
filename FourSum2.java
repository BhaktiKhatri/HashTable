package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/description/
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is 
 * guaranteed to be at most 231 - 1.
 * Example: Input: A = [ 1, 2], B = [-2,-1], C = [-1, 2], D = [ 0, 2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * Explanation and Code from: @mycoy02 https://leetcode.com/problems/4sum-ii/discuss/93920/Clean-java-solution-O(n2)
 * Time complexity:  O(n^2)
 * Space complexity: O(n^2)
 */

public class FourSum2 {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 		//key-sum; value-frequency of sum
        
        System.out.println("A: "+Arrays.toString(A)+" B: "+Arrays.toString(B)+" C: "+Arrays.toString(C)+" D: "+Arrays.toString(D));
        
        for(int a : A) {
            for(int b : B) {
            	System.out.println("a: "+a+" b: "+b);
            	
                int sum = a + b;
                System.out.println("sum: "+sum);
                
                map.put(sum, map.getOrDefault(sum, 0) + 1); 
                System.out.println("map: "+map);
            }
        }
        
        int result=0;
        
        for(int c : C) {
            for(int d : D) {
            	System.out.println("c: "+c+" d: "+d);
            	
                int diff = -c-d;
                System.out.println("diff: "+diff);
                
                result = result + map.getOrDefault(diff, 0);
                System.out.println("result: "+result);
            }
        }
        
        System.out.println("result: "+result);
        return result; 
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2};
		int[] B = {-2,-1};
		int[] C = {-1, 2};
		int[] D = {0, 2};
		
		System.out.println(fourSumCount(A, B, C, D));
	}

}
