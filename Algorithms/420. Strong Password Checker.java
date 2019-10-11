/*
https://leetcode.com/problems/strong-password-checker/
 */


/*A password is considered strong if below conditions are all met:

It has at least 6 characters and at most 20 characters.
It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

Insertion, deletion or replace of any one character are all considered as one change.*/

/*Input: aaabbbccc
Output: 3

Input: aAbVbCc1AAAVVGG
Output: 1*/
public class Solution {

    public int strongPasswordChecker(String s) {
        int res = 0, lowerCase = 1, upperCase = 1, digit = 1;
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];

        for (int i = 0; i < arr.length;) {
            if (Character.isLowerCase(carr[i])) lowerCase = 0;
            if (Character.isUpperCase(carr[i])) upperCase = 0;
            if (Character.isDigit(carr[i])) digit = 0;

            int j = i;
            while (i < carr.length && carr[i] == carr[j]) {
                i++;
            }
            arr[j] = i - j;
        }

        int totalMissing = (lowerCase + upperCase + digit);

        if (arr.length < 6) {
            res += totalMissing + Math.max(0, 6 - (arr.length + totalMissing));

        } else {
            int overLen = Math.max(arr.length - 20, 0), leftOver = 0;
            res += overLen;

            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && overLen > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) continue;
                    arr[i] -= Math.min(overLen, k);
                    overLen -= k;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && overLen > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= overLen;
                    overLen -= need;
                }

                if (arr[i] >= 3) leftOver += arr[i] / 3;
            }
            res += Math.max(totalMissing, leftOver);
        }
        return res;
    }

}
