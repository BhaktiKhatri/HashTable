package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
 * 957. Prison Cells After N Days
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant. (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 * Example 1: Input: cells = [0,1,0,1,1,0,0,1], N = 7; Output: [0,0,1,1,0,0,0,0]
 * Explanation: The following table summarizes the state of the prison on each day:
	Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
	Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
	Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
	Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
	Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
	Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
	Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
	Day 7: [0, 0, 1, 1, 0, 0, 0, 0] 
 * Example 2: Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000; Output: [0,0,1,1,1,1,1,0]
 * Note: cells.length == 8; cells[i] is in {0, 1}; 1 <= N <= 10^9
 * Explanation and Code from: @lee215 https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14 
 */

public class PrisonCellsAfterNDays {

    public static int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        System.out.println("cells: "+Arrays.toString(cells)+" N: "+N);
        
        while(N > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            System.out.println("seen: "+seen);
            
            for(int i=1; i<7; i++) {
            	
                if(cells[i - 1] == cells[i + 1]) {
                	cells2[i] = 1;
                }
                else {
                	cells2[i] = 0;
                }
            }
            cells = cells2;
            
            if (seen.containsKey(Arrays.toString(cells))) {
            	System.out.println("hi");
                N = N % seen.get(Arrays.toString(cells)) - N;	//seen.get(Arrays.toString(cells)) is the last time when the same cells appear, seen.get(Arrays.toString(cells))-N is the cycle length. %= cuts down the loop times.
            }
        }
        return cells;
    }
	
	public static void main(String[] args) {
		int[] cells = {0,1,0,1,1,0,0,1};
		int N = 7;
		
		cells = prisonAfterNDays(cells, N);
		System.out.println("cells: "+Arrays.toString(cells));
	}
}