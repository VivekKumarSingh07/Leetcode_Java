import java.util.*;
import java.util.stream.Collectors;

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> numsList = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toList());

        return this.fourSum(numsList, target);
    }

    private List<List<Integer>> fourSum(List<Integer> nums, int target) {
        int size = nums.size();
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> subNums = new LinkedList<>(nums);
            int current = subNums.remove(i);
            for (int j = 0; j < subNums.size(); j++) {
                if (j + 3 > subNums.size()) break;
                List<Integer> temp = buildTempSubList(subNums, current, j, 4);
                if (sum(temp) == target && !result.containsAll(temp)) {
                    result.add(temp);
                }
                result.addAll(fourSum(subNums, target));
            }

        }
        return result
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Integer> buildTempSubList(List<Integer> subNums, int current, int j, int arraySize) {
        List<Integer> temp = new LinkedList<>();
        temp.add(current);
        temp.addAll(subNums.subList(j, j + arraySize - 1));
        temp.sort(Comparator.naturalOrder());
        return temp;
    }

    private Integer sum(List<Integer> temp) {
        return temp.stream().reduce(0, Integer::sum);
    }

}
