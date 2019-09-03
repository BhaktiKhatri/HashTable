package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 314. Binary Tree Vertical Order Traversal
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * Examples:
	Given binary tree [3,9,20,null,null,15,7],
	   3
	  /\
	 /  \
	 9  20
	    /\
	   /  \
	  15   7
	return its vertical order traversal as:
	[
	  [9],
	  [3,15],
	  [20],
	  [7]
	]
	Given binary tree [3,9,8,4,0,1,7],
	     3
	    /\
	   /  \
	   9   8
	  /\  /\
	 /  \/  \
	 4  01   7
	return its vertical order traversal as:
	[
	  [4],
	  [9],
	  [3,0,1],
	  [8],
	  [7]
	]
	Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
	     3
	    /\
	   /  \
	   9   8
	  /\  /\
	 /  \/  \
	 4  01   7
	    /\
	   /  \
	   5   2
	return its vertical order traversal as:
	[
	  [4],
	  [9,5],
	  [3,0,1],
	  [8,2],
	  [7]
	]
	Explanation and Code from: https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/76401/5ms-Java-Clean-Solution?page=1
	https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
	Google, Facebook, Snapchat
	Medium
 */

public class BinaryTreeVerticalOrderTraversal {

	TreeNode root;
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
	    List<List<Integer>> cols = new ArrayList<>();
	    
	    if(root == null) {
	        return cols;
	    }
	    
	    System.out.println("root: "+root.val);
	    
	    int[] range = new int[] {0, 0};
	    getRange(root, range, 0);
	    
	    System.out.println("root: "+root.val+" range: "+Arrays.toString(range));
	    
	    for(int i=range[0]; i<=range[1]; i++) {
	        cols.add(new ArrayList<Integer>());
	    }
	    
	    System.out.println("cols: "+cols);
	    
	    Queue<TreeNode> queue = new LinkedList<>();
	    Queue<Integer> colQueue = new LinkedList<>();
	    
	    queue.add(root);
	    colQueue.add(-range[0]);
	    
	    System.out.println("queue: "+queue+" colQueue: "+colQueue);
	    
	    while(!queue.isEmpty()) {
	    	
	    	System.out.println("queue: "+queue+" colQueue: "+colQueue);
	    	
	        TreeNode node = queue.poll();
	        int col = colQueue.poll();
	        
	        System.out.println("node: "+node.val+" col: "+col);
	        
	        cols.get(col).add(node.val);
	        
	        System.out.println("cols: "+cols);
	        
	        if(node.left != null) {
	            queue.add(node.left);   
	            colQueue.add(col - 1);
	        }
	        
	        System.out.println("queue: "+queue+" colQueue: "+colQueue);
	        
	        if (node.right != null) {
	            queue.add(node.right);
	            colQueue.add(col + 1);
	        }
	        
	        System.out.println("queue: "+queue+" colQueue: "+colQueue);
	    }
	    
	    return cols;
	}

	public static void getRange(TreeNode root, int[] range, int col) {
	    if(root == null) {
	        return;
	    }
	    
	    System.out.println("root: "+root.val+" col: "+col+" range: "+Arrays.toString(range));
	    
	    range[0] = Math.min(range[0], col);
	    range[1] = Math.max(range[1], col);
	    
	    System.out.println("root: "+root.val+" col: "+col+" range: "+Arrays.toString(range));
	    
	    getRange(root.left, range, col - 1);
	    getRange(root.right, range, col + 1);
	}
	
	public static void main(String[] args) {
		BinaryTreeVerticalOrderTraversal tree = new BinaryTreeVerticalOrderTraversal();
		
		/*
		 	     3
			    /\
			   /  \
			  9     8 
			 /\    /\
		    /  \  /  \
		   4   0  1   7
		 
		 */
		
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(0);
		tree.root.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(1);
		tree.root.right.right = new TreeNode(7);
		
		System.out.println(verticalOrder(tree.root));
	}

}
