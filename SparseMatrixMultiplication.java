package HashTable;

/*
 * 311. Sparse Matrix Multiplication
 * https://leetcode.com/problems/sparse-matrix-multiplication/description/
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * Example:
	A = [
	  [ 1, 0, 0],
	  [-1, 0, 3]
	]
	
	B = [
	  [ 7, 0, 0 ],
	  [ 0, 0, 0 ],
	  [ 0, 0, 1 ]
	]
		
	     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
	AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
	                  | 0 0 1 |
	Explanation and Code from: https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76154/Easiest-JAVA-solution https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76151/54ms-detailed-summary-of-easiest-java-solutions-beating-999
	Facebook, LinkedIn
	Medium
 */

public class SparseMatrixMultiplication {

	public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i=0; i<m; i++) {
            for(int k=0; k<n; k++) {
            	
            	System.out.println("i: "+i+" k: "+k+" A[i][k]: "+A[i][k]);
            	
                if(A[i][k] != 0) {
                    for (int j=0; j<nB; j++) {
                    	
                    	System.out.println("j: "+j+" B[k][j]: "+B[k][j]+" A[i][k]: "+A[i][k]+" A[i][k] * B[k][j]: "+(A[i][k] * B[k][j])+" C[i][j]: "+C[i][j]);
                    	
                        if (B[k][j] != 0)  {
                        	C[i][j] = C[i][j] + A[i][k] * B[k][j];
                        	
                        	System.out.println("C[i][j]: "+C[i][j]);
                        }
                    }
                }
            }
        }
        return C;   
    }
	
	public static void main(String[] args) {
		int[][] A = {{ 1, 0, 0},
		             {-1, 0, 3}
					};
		
		int[][] B = {
					 { 7, 0, 0 },
					 { 0, 0, 0 },
		             { 0, 0, 1 }
					};
		
		int[][] C = multiply(A, B);
		
		for(int i=0; i<C.length; i++) {
			for(int j=0; j<C[0].length; j++) {
				System.out.print(" "+C[i][j]+" ");
			}
			System.out.println();
		}
	
	}

}
