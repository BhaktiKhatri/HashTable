package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 288. Unique Word Abbreviation
 * https://leetcode.com/problems/unique-word-abbreviation/description/
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 *   1
 *    ↓
 * b) d|o|g                   --> d1g
 *
 *              1    1  1
 *     1---5----0----5--8
 *     ↓   ↓    ↓    ↓  ↓    
 * c) i|nternationalizatio|n  --> i18n
 *
 *              1
 *     1---5----0
 *     ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * Example: Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * Explanation and Code from: Approach #3 HashTable https://leetcode.com/problems/unique-word-abbreviation/solution/
 * https://leetcode.com/problems/unique-word-abbreviation/discuss/73141/Let-me-explain-the-question-with-better-examples.
 * Time complexity : O(n) pre-processing, O(1) for each isUnique call. Both Approach #2 and Approach #3 above take O(n) pre-processing time in the constructor. This is totally worth it if isUnique is called repeatedly.
 * Space complexity : O(n); We traded the extra O(n) space storing the table to reduce the time complexity in isUnique.
 * Google
 * Medium
 */

public class ValidWordAbbr {

    private final Map<String, Boolean> abbrDict = new HashMap<>();		//key-abbr; value-boolean if abbr is unique or not i.e {c2d=true, d2r=false, c2e=true}
    private final Set<String> dict;

    public ValidWordAbbr(String[] dictionary) {
    	System.out.println("dictionary: "+Arrays.toString(dictionary));
        dict = new HashSet<>(Arrays.asList(dictionary));

        for(String s: dict) {
        	System.out.println("s: "+s);
            
        	String abbr = toAbbr(s);
            System.out.println("abbr: "+abbr+" abbrDict: "+abbrDict+" abbrDict.containsKey(abbr): "+abbrDict.containsKey(abbr));
            
            abbrDict.put(abbr, !abbrDict.containsKey(abbr));
            System.out.println("abbrDict: "+abbrDict);
        }
    }

    public boolean isUnique(String word) {
    	System.out.println("word: "+word);
        String abbr = toAbbr(word);	
        System.out.println("abbr: "+abbr+" abbrDict: "+abbrDict);
        
        Boolean hasAbbr = abbrDict.get(abbr);
        System.out.println("hasAbbr: "+hasAbbr+" dict: "+dict+" dict.contains(word): "+dict.contains(word));
        
        return hasAbbr == null || (hasAbbr && dict.contains(word));
    }

    private String toAbbr(String s) {
    	System.out.println("s: "+s);
        int n = s.length();
        System.out.println("n: "+n);
        
        if(n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }

	public static void main(String[] args) {
		String[] dictionary = {"deer", "door", "cake", "card"};
		ValidWordAbbr abbr = new ValidWordAbbr(dictionary);
		
		String word = "door";
		System.out.println(abbr.isUnique(word));
	}

}
