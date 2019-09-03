package HashTable;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 356. Line Reflection
 * https://leetcode.com/problems/line-reflection/description/
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * Example 1: Given points = [[1,1],[-1,1]], return true.
 * Example 2: Given points = [[1,1],[-1,-1]], return false.
 * Follow up: Could you do better than O(n2)?
 * Explanation from: @Erick111 https://leetcode.com/problems/line-reflection/discuss/82968/11ms-two-pass-HashSet-based-Java-Solution?page=1
 * Code from: @juanren https://leetcode.com/problems/line-reflection/discuss/82970/Simple-java-hashset-solution
 * Google
 * Medium
 */

public class LineReflection {

	/*
	 * The idea is quite simple. If there exists a line reflecting the points, then each pair of symmetric points will have their x coordinates adding up to 
	 * the same value, including the pair with the maximum and minimum x coordinates. So, in the first pass, I iterate through the array, adding each point
	 * to the hash set, and keeping record of the minimum and maximum x coordinates. Then, in the second pass, I check for every point to the left of the 
	 * reflecting line, if its symmetric point is in the point set or not. If all points pass the test, then there exists a reflecting line. Otherwise, not.
	 */
	
	/*
	 * Reflection point of [1,1] is [-1,1] and that of [-1, 1] is [1,1]
	 * Now add the x-coordinates of the given points with its reflection point
	 * Sum should be the same as both would lie to the opposite direction of y=0
	 * Add given points into the set
	 * Check if the reflection point is in the set
	 * If yes for all given points then return true 
	 */
	
	  public static boolean isReflected(int[][] points) {
		    int max = Integer.MIN_VALUE;
		    int min = Integer.MAX_VALUE;
		    HashSet<String> set = new HashSet<>();
		    
		    for(int[] p: points) {
		    	System.out.println("p: "+Arrays.toString(p)+" p[0]: "+p[0]+" max: "+max+" min: "+min);
		    	
		        max = Math.max(max, p[0]);
		        min = Math.min(min, p[0]);
		        System.out.println("max: "+max+" min: "+min);
		        
		        String str = p[0] + "a" + p[1];
		        System.out.println("str: "+str);
		        
		        set.add(str);
		        System.out.println("set: "+set);
		    }
		    
		    int sum = max + min;
		    System.out.println("sum: "+sum);
		    
		    for(int[] p: points) {
		    	System.out.println("p: "+Arrays.toString(p));
		    	
		        String str = (sum - p[0]) + "a" + p[1];
		        System.out.println("str: "+str);
		        
		        if(!set.contains(str)) {
		            return false;
		        }
		    }
		    return true;
	}
	
	public static void main(String[] args) {
		int[][] points = {{1,1},{-1,1}};
		System.out.println(isReflected(points));
	}
}