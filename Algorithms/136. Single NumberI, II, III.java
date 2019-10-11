/*
https://leetcode.com/problems/single-number/
 */


/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Extra: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?.*/

/*Input: 1,2,3,2,3
Output: 1

Input: 4,1,2,1,2
Output: 4

Input: 1,1,2,2,5,6,5
Output: 6*/

public class Solution {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}