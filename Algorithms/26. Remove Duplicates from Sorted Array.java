//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

//Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

//Example 1:
//Input: [1,1,2]
//Output: 2 
//Explanation: Given nums = [1,1,2],
//			   Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//			   It doesn't matter what you leave beyond the returned length.

//Example 2:
//Input: [0,0,1,1,1,2,2,3,3,4]
//Output: 5
//Explanation: Given nums = [1,1,2],
//			   Your function should return length = 5, 
//			   with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively

//Solution

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[count-1] != nums[i]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}