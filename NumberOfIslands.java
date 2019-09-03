package HashTable;

/*
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent
 * lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1: Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * Example 2: Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 * Explanation and Code from: @wcyz666 https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
 * Google, Facebook, Microsoft, Amazon, Zenefits
 */

public class NumberOfIslands {

	public static int m = 0, n = 0;
    
    public static int numIslands(char[][] grid) {
        m = grid.length;
        
        if(m == 0)
            return 0;
        
        n = grid[0].length;
        int count = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
            	
            	System.out.println("i: "+i+" j: "+j+" grid[i][j]: "+grid[i][j]);
            	
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void dfs(char[][] grid, int i, int j) {
    	System.out.println("i: "+i+" j: "+j);
    	
    	if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
            return;
        
        System.out.println("i: "+i+" j: "+j+" grid[i][j]: "+grid[i][j]);
        
        grid[i][j] = '0';
        
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
	
	public static void main(String[] args) {
		char[][] grid =  {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
			};

		System.out.println(numIslands(grid));
	}

}