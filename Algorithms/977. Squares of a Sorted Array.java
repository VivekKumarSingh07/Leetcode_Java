//https://leetcode.com/problems/squares-of-a-sorted-array/

//Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

//Example 1:
//
//Input: [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//
// Example 2:
//
//Input: [-7,-3,2,3,11]
//Output: [4,9,9,49,121]

class Solution {
    public int[] sortedSquares(int[] a) {
        int n = a.length;
        int j = 0;
        while (j < n && a[j] < 0) {
            j++;
        }
        int i = j - 1;

        int[] ans = new int[n];
        int t = 0;

        while (i >= 0 && j < n) {
            if (a[i] * a[i] < a[j] * a[j]) {
                ans[t++] = a[i] * a[i];
                i--;
            } else {
                ans[t++] = a[j] * a[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = a[i] * a[i];
            i--;
        }
        while (j < n) {
            ans[t++] = a[j] * a[j];
            j++;
        }

        return ans;
    }
}
