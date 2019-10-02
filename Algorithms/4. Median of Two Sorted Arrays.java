//https://leetcode.com/problems/median-of-two-sorted-arrays/

/**
 *  There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *  
 *  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *  
 *  You may assume nums1 and nums2 cannot be both empty.
 *  
 *  Example 1:
 *  
 *  nums1 = [1, 3]
 *  nums2 = [2]
 *  
 *  The median is 2.0
 *  Example 2:
 *  
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 *  
 *  The median is (2 + 3)/2 = 2.5
 */

//Solution

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mergedLen = len1 + len2;
        int middle = mergedLen / 2;

        int[] merged = new int[mergedLen];
        System.arraycopy(nums1, 0, merged, 0, len1);
        System.arraycopy(nums2, 0, merged, len1, len2);
        Arrays.parallelSort(merged);

        double result;
        if((mergedLen & 1) == 0) {
            result = (merged[middle - 1] + merged[middle]) / 2d;
        } else {
            result = merged[middle];
        }

        return result;
    }
}
