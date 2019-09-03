package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 554. Brick Wall
 * https://leetcode.com/problems/brick-wall/description/
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least
 * bricks and return the number of crossed bricks.
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * Example:
 * Input: 
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 * Note: The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. 
 * Total number of bricks of the wall won't exceed 20,000.
 * Explanation and Code from: Approach #3 Using HashMap https://leetcode.com/problems/brick-wall/solution/
 * https://leetcode.com/problems/brick-wall/discuss/101728/I-DON'T-THINK-THERE-IS-A-BETTER-PERSON-THAN-ME-TO-ANSWER-THIS-QUESTION
 * Time complexity : O(n); We traverse over the complete bricks only once. n is the total number of bricks in a wall.
 * Space complexity : O(m); map will contain at most m entries, where m refers to the width of the wall.
 * Facebook
 * Medium
 */

public class BrickWall {

	//We want to cut from the edge of the most common location among all the levels, hence using a map to record the locations and their corresponding occurrence.
    public static int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0)
        	return 0;
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(List<Integer> row: wall) {
        	System.out.println("row: "+row);
        	
            int sum = 0;
            for(int i=0; i<row.size()-1; i++) {
            	System.out.println("i: "+i+" row.get(i): "+row.get(i)+" sum: "+sum);
            	
            	sum = sum + row.get(i);
            	System.out.println("sum: "+sum);
            	
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                System.out.println("map: "+map+" map.get(sum): "+map.get(sum));
                
                count = Math.max(count, map.get(sum));
                System.out.println("count: "+count);
            }
        }
        System.out.println("wall.size(): "+wall.size()+" count: "+count);
        
        return wall.size() - count;
    }

	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(1);
		list1.add(2);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(3);
		list2.add(2);
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(2);
		list3.add(4);
		
		List<Integer> list4 = new ArrayList<>();
		list4.add(3);
		list4.add(1);
		list4.add(2);
		
		List<Integer> list5 = new ArrayList<>();
		list5.add(1);
		list5.add(3);
		list5.add(3);
		list5.add(1);
		
		List<List<Integer>> wall = new ArrayList<>();
		wall.add(list);
		wall.add(list1);
		wall.add(list2);
		wall.add(list3);
		wall.add(list4);
		wall.add(list5);
		
		System.out.println(leastBricks(wall));
	}

}
