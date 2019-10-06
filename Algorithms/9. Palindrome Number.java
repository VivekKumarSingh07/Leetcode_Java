//https://leetcode.com/problems/palindrome-number/description/

//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

//Example 1:

//Input: 121
//Output: true

//Example 2:

//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

//Example 3:

//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

//Follow up: Coud you solve it without converting the integer to a string?

//Solution

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int i = 0;
        int j = (int)Math.log10(x);

        while(i < j) {
            if (getNthDigit(x, i) != getNthDigit(x, j)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public int getNthDigit(int number, int n) {
        int base = (int)Math.pow(10, n);
        return (number / base) % 10;
    }
}