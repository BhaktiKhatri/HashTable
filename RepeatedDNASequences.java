package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
 * repeated sequences within the DNA. Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example, Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", Return: ["AAAAACCCCC", "CCCCCAAAAA"]
 * Explanation and Code from: https://leetcode.com/problems/repeated-dna-sequences/discuss/53855/7-lines-simple-Java-O(n)
 * LinkedIn
 * Medium
 */

public class RepeatedDNASequences {

	//In addition to adding the element to the set, it will also check if the element is already inside the set and return the result as a boolean
	//Yes, the substring length is the constant 10 here
	//set.add operation just take O(1) time
	public static List<String> findRepeatedDnaSequences(String s) {
	    Set<String> seen = new HashSet<String>();
	    Set<String> repeated = new HashSet<String>();
	    
	    System.out.println("s: "+s+" s.length(): "+s.length());
	    
	    for (int i = 0; (i+9) < s.length(); i++) {
	        System.out.println("i: "+i);
	        
	    	String ten = s.substring(i, i + 10);
	        System.out.println("ten: "+ten+" seen: "+seen);
	    	
	        if (!seen.add(ten)) {
	            repeated.add(ten);
	        }
	        System.out.println("repeated: "+repeated);
	    }
	    System.out.println("repeated: "+repeated);
	    return new ArrayList<String>(repeated);
	}
	
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(findRepeatedDnaSequences(s));
	}

}
