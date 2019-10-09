//https://leetcode.com/problems/3sum-closest/description/

//Given an array nums of n integers and an integer target, find three integers
//in nums such that the sum is closest to target. Return the sum of the three
//integers. You may assume that each input would have exactly one solution.

//Example:

//Given array nums = [-1, 2, 1, -4], and target = 1.
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

//Solution

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minValue = 0;
        int minDif = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int l = i+1;
            int r = nums.length - 1;

            while (l < r) {
                int currentValue = current + nums[l] + nums[r];
                int dif = Math.abs(target - currentValue);

                if (dif < minDif) {
                    minDif = dif;
                    minValue = currentValue;
                }

                if (currentValue > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return minValue;
    }
}