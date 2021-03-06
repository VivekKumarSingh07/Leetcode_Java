//https://leetcode.com/problems/reverse-integer/

//Given a 32-bit signed integer, reverse digits of an integer.

//Example
//Input: 123
//Output: 321

//Solution

class Solution {
	public int reverse(int x) {
		long reverse = 0;
		int decimal_max = 10;
		while (x != 0)
		{
			reverse = reverse * decimal_max + x % decimal_max;
			x = x / decimal_max;
		}

		if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE)
		{
			return 0;
		} else
		{
			return (int) reverse;
		}
	}
}
