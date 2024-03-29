package HashTable;

import java.util.Arrays;

/*
 * 748. Shortest Completing Word
 * https://leetcode.com/problems/shortest-completing-word/description/
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete
 * the given string licensePlate
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
 * Example 1: Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]; Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the word twice. Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 * Example 2: Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]; Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s". We return the one that occurred first.
 * Note: licensePlate will be a string with length in range [1, 7]. licensePlate will contain digits, spaces, or letters (uppercase or lowercase). 
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 * Explanation and Code from: https://leetcode.com/problems/shortest-completing-word/solution/
 * Time Complexity: O(N) where N is the length of words, and assuming the lengths of licensePlate and words[i] are bounded by O(1)
 * Space Complexity: O(1) in additional space
 * Google
 * Medium
 */

public class ShortestCompletingWord {

	/*
	 * A natural question is, how to tell whether a word like "steps" completes a licensePlate like "12s pst"?
	 * We count the number of letters in both word and licensePlate, converting to lowercase and ignoring non-letter characters. 
	 * If the count of each letter is greater or equal in the word, then that word completes the licensePlate.
	 * From the words that complete licensePlate, we should keep the one with the shortest length (with ties broken by whether it occurs first.)
	 */
    public static String shortestCompletingWord(String licensePlate, String[] words) {
    	System.out.println("licensePlate: "+licensePlate+" words: "+Arrays.toString(words));
    	
        int[] target = count(licensePlate);
        System.out.println("target: "+Arrays.toString(target));
        
        String ans = "";
        for(String word: words) {
        	System.out.println("word: "+word+" word.length(): "+word.length()+" ans.length(): "+ans.length());
            
        	if((word.length() < ans.length() || ans.length() == 0) && dominates(count(word.toLowerCase()), target)) {
        		System.out.println("ans: "+ans+" word: "+word);
                ans = word;
            }
        }
        System.out.println("ans: "+ans);
        return ans;
    }

    public static boolean dominates(int[] count1, int[] count2) {
    	for(int i=0; i<26; i++) {
        	System.out.println("count1[i]: "+count1[i]+" count2[i]: "+count2[i]);
            if(count1[i] < count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] count(String word) {
        int[] ans = new int[26];
        System.out.println("word: "+word);
        
        for(char letter: word.toCharArray()) {
        	System.out.println("letter: "+letter);
            
        	int index = Character.toLowerCase(letter) - 'a';
            System.out.println("index: "+index);
        	
            if(0 <= index && index < 26) {
                ans[index]++;
            }
        }
        return ans;
    }

	
	public static void main(String[] args) {
		String licensePlate = "1s3 PSt";
		String[] words = {"step", "steps", "stripe", "stepple"};
		
		System.out.println(shortestCompletingWord(licensePlate, words));
	}

}
