package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 	36. Valid Sudoku
 	https://leetcode.com/problems/valid-sudoku/description/
 	
 	Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
	
	Explanation and Code from: https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code
	
 */

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board)
	{
		int[][] used1 = new int[9][9];
		int[][] used2 = new int[9][9];
		int[][] used3 = new int[9][9];

			for(int i=0; i<board.length; ++i)
			{
				for(int j=0; j<board[i].length; ++j)
				{
					System.out.println("i: "+i+" j: "+j+" board[i][j]: "+board[i][j]);
					
					if(board[i][j] != '.')
					{
						int num = board[i][j] - '0' - 1;
						int k = i / 3 * 3 + j / 3;
				
						System.out.println("num: "+num+" k: "+k);
						System.out.println("used1[i][num]: "+used1[i][num]+" used2[j][num]: "+used2[j][num]+" used3[k][num]: "+used3[k][num]);
						
						if (used1[i][num] != 0 || used2[j][num] != 0 || used3[k][num] != 0)
						{
							return false;
						}
						used1[i][num] = used2[j][num] = used3[k][num] = 1;
					}
				}
			}

			return true;
	}

	public static boolean isValidSudoku1(char[][] board) {
	    for(int i=0; i<9; i++) {
	        
	    	HashSet<Character> rows = new HashSet<Character>();
	        HashSet<Character> columns = new HashSet<Character>();
	        HashSet<Character> cube = new HashSet<Character>();
	        
	        System.out.println("i: "+i);
	        
	        for (int j=0; j<9; j++) {
	        	
	        	System.out.println("i: "+i+" j: "+j+" board[i][j]: "+board[i][j]+" board[j][i]: "+board[j][i]);
	        	
	            if(board[i][j]!='.' && !rows.add(board[i][j]))
	                return false;
	            
	            if(board[j][i]!='.' && !columns.add(board[j][i]))
	                return false;
	            
	            int RowIndex = 3 * (i/3);	//vertical;    Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 = 0; 3/3 = 1
	            int ColIndex = 3 * (i%3);	//horizontal;  Because % increments by 1 for each j : 0 % 3 = 0, 1 % 3 = 1, 2 % 3 = 2
	            
	            System.out.println("RowIndex: "+RowIndex+" ColIndex: "+ColIndex+" board[RowIndex + j/3][ColIndex + j%3]: "+board[RowIndex + j/3][ColIndex + j%3]);
	            
	            if(board[RowIndex + j/3][ColIndex + j%3] != '.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	                return false;
	        }
	    }
	    return true;
	}
	
	/*
	 * row index: vertical;    Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 = 0; 3/3 = 1
	 * col index: horizontal;  Because % increments by 1 for each j : 0 % 3 = 0, 1 % 3 = 1, 2 % 3 = 2
	 * Refer this: @Stefan https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
	 */
	public static boolean isValidSudoku2(char[][] board) {
	    Set<String> seen = new HashSet<>();
	    
	    for(int i=0; i<9; i++) {
	       for(int j=0; j<9; j++) {
	        	System.out.println("i: "+i+" j: "+j+" board[i][j]: "+board[i][j]+" i/3: "+i/3+" j/3: "+j/3);
	        	
	            char number = board[i][j];
	            System.out.println("number: "+number+" seen: "+seen);
	            
	            if(number != '.') {
	               if(!seen.add(number + " in row " + i) || !seen.add(number + " in column " + j) || !seen.add(number + " in block " + i/3 + "-" + j/3))
	                    return false;
	            }
	        }
	    }
	    System.out.println("seen: "+seen);
	    return true;
	}
	
	public static boolean isValidSudoku3(char[][] board) {
	    // init data
	    HashMap<Integer, Integer> [] rows = new HashMap[9];
	    HashMap<Integer, Integer> [] columns = new HashMap[9];
	    HashMap<Integer, Integer> [] boxes = new HashMap[9];
	    
	    for (int i = 0; i < 9; i++) {
	      rows[i] = new HashMap<Integer, Integer>();
	      columns[i] = new HashMap<Integer, Integer>();
	      boxes[i] = new HashMap<Integer, Integer>();
	    }

	    // validate a board
	    for (int i = 0; i < 9; i++) {
	      for (int j = 0; j < 9; j++) {
	        
	    	  char num = board[i][j];
	        
	    	  if (num != '.') {
	          int n = (int)num;
	          int box_index = (i / 3 ) * 3 + j / 3;

	          // keep the current cell value
	          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
	          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
	          boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

	          System.out.println("rows: "+rows+" cols: "+columns+" boxes: "+boxes);
	          
	          // check if this value has been already seen before
	          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
	            return false;
	        }
	      }
	    }
	    System.out.println("rows: "+rows+" cols: "+columns+" boxes: "+boxes);
	    
	    return true;
	  }

	
	public static void main(String[] args) {
		char[][] board = { {'8','3','.','.','7','.','.','.','.'},
						   {'6','.','.','1','9','5','.','.','.'},
						   {'.','9','8','.','.','.','.','6','.'},
						   {'8','.','.','.','6','.','.','.','3'},
						   {'4','.','.','8','.','3','.','.','1'},
						   {'7','.','.','.','2','.','.','.','6'},
						   {'.','6','.','.','.','.','2','8','.'},
						   {'.','.','.','4','1','9','.','.','5'},
						   {'.','.','.','.','8','.','.','7','9'},
						  };
		
		System.out.println(isValidSudoku2(board));
	}

}
