package HashTable;

import java.util.HashMap;
import java.util.Map;

/*
 * 166. Fraction to Recurring Decimal
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example, Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2, denominator = 1, return "2". Given numerator = 2, denominator = 3, return "0.(6)".
 * Explanation and Code from: https://leetcode.com/problems/fraction-to-recurring-decimal/solution/
 * Google, IXL
 * Medium
 */

public class FractionToRecurringDecimal {

	public static String fractionToDecimal(int numerator, int denominator) {
	    if(numerator == 0) {
	        return "0";
	    }
	    System.out.println("numerator: "+numerator+" denominator: "+denominator);
	    
	    StringBuilder fraction = new StringBuilder();

	    //If either one is negative (not both)
	    if (numerator < 0 ^ denominator < 0) {
	        fraction.append("-");
	    }
	    
	    //Convert to Long or else abs(-2147483648) overflows
	    long dividend = Math.abs(Long.valueOf(numerator));
	    long divisor = Math.abs(Long.valueOf(denominator));
	    fraction.append(String.valueOf(dividend / divisor));
	    
	    System.out.println("dividend: "+dividend+" divisor: "+divisor+" fraction: "+fraction);
	    
	    long remainder = dividend % divisor;
	    System.out.println("remainder: "+remainder);
	    
	    if(remainder == 0) {
	        return fraction.toString();
	    }
	    
	    fraction.append(".");
	    System.out.println("fraction: "+fraction);
	    
	    Map<Long, Integer> map = new HashMap<>();
	    while (remainder != 0) {
	    	System.out.println("map: "+map+" remainder: "+remainder+" map.get(remainder): "+map.get(remainder)+" fraction: "+fraction);
	    	
	        if(map.containsKey(remainder)) {
	            fraction.insert(map.get(remainder), "(");
	            fraction.append(")");
	            break;
	        }
	        map.put(remainder, fraction.length());
	        remainder = remainder * 10;
	        fraction.append(String.valueOf(remainder / divisor));
	        remainder = remainder % divisor;
	    }
	    System.out.println("fraction: "+fraction+" remainder: "+remainder);
	    
	    return fraction.toString();
	}
	
	public static void main(String[] args) {
		int numerator = 1;
		int denominator = 2;
		
		System.out.println(fractionToDecimal(numerator, denominator));
	}

}
