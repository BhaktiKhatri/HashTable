package HashTable;

import java.util.HashSet;
import java.util.Set;

/*
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you 
 * have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * Example 1: Input: J = "aA", S = "aAAbbbb"; Output: 3
 * Example 2: Input: J = "z", S = "ZZ"; Output: 0
 * Note: S and J will consist of letters and have length at most 50. The characters in J are distinct.
 * Explanation and Code from: https://leetcode.com/problems/jewels-and-stones/solution/
 * Time Complexity: O(J.length+S.length)). The O(J.length) part comes from creating J. The O(S.length) part comes from searching S.
 * Space Complexity: O(J.length)
 * Easy
 * Amazon
 */

public class JewelsAndStones {

	public static int numJewelsInStones(String J, String S) {
        Set<Character> Jset = new HashSet<Character>();
        
        System.out.println("J: "+J+" S: "+S);
        
        for(char j: J.toCharArray()) {
            Jset.add(j);
        }
        System.out.println("Jset: "+Jset);
        
        int ans = 0;
        for(char s: S.toCharArray()) {
        	System.out.println("s: "+s);
            if(Jset.contains(s)) {
                ans++;
            }
        }
        System.out.println("ans: "+ans);
        
        return ans;
    }
	
	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		
		System.out.println(numJewelsInStones(J, S));
	}

}
