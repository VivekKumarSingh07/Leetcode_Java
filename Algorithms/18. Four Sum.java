//https://leetcode.com/problems/4sum/description/

//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in
//nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the
//sum of target.

//Note:
//The solution set must not contain duplicate quadruplets.

//Example:
// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]

//Solution

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int low = j + 1;
                int high = nums.length - 1;
                int remaining = target - nums[i] - nums[j];

                while (low < high) {
                    int acc = nums[low] + nums[high];
                    if (acc == remaining) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

                        while (high > low && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;
                    }
                    else if (acc > remaining) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return result;
    }
}