/*
https://leetcode.com/problems/sliding-window-maximum/
 */


/*Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.*/

/*Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]

Input: nums = [1,3,4,4,5,5], and k = 3
Output: [4, 4, 5, 5]
*/

public class Solution {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        ArrayDeque<Integer> deque =  new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && i-k == deque.peekFirst()){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i+1-k >=0){
                res[i+1-k] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

}