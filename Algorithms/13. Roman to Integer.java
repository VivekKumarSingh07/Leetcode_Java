//https://leetcode.com/problems/roman-to-integer/

//Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

//Example 1:
//Input: "III"
//Output: 3

//Example 2:
//Input: "IX"
//Output: 9

//Example 3:
//Input: "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.

//Example 4:
//Input: "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

public class Solution {
	
	public int romanToInt(String s) {

		Map<Character, Integer> integerForRoman = new HashMap<>();
        integerForRoman.put('I', 1);
	    integerForRoman.put('V', 5);
	    integerForRoman.put('X', 10);
	    integerForRoman.put('L', 50);
	    integerForRoman.put('C', 100);
	    integerForRoman.put('D', 500);
	    integerForRoman.put('M', 1000);
	    
	    int curr = 0;
	    int sum = 0;
	    
	    if (s.length() == 0) {return 0;}
	    
	    if (s.length() == 1) {
	        return integerForRoman.get(s.charAt(0));
	    }
	    for (int i = s.length()-1; i>=0; --i) {
	        if (integerForRoman.get(s.charAt(i)) >= curr) {
	            curr = integerForRoman.get(s.charAt(i));
	            sum += curr;
	        }
	        else {
	            curr = integerForRoman.get(s.charAt(i));
	            sum -= curr;
	        }
	    }
	    return sum;
	}
	
}
