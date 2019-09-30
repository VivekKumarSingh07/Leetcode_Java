//https://leetcode.com/problems/first-missing-positive/

//Given an unsorted integer array, find the smallest missing positive integer.

//Example:
//Input: [3,4,-1,1]
//Output: 2
//Explanation: After 1, 2 is missing. Hence return it

//Input: [1,2,0]
//Output: 3
//Explanation: No +ve number is missing there return next positive number 3.

//Note: Solve the problem in O(n) ans constant extra space

//Solution

import java.util.Arrays; 
class Solution {
    public int firstMissingPositive(int[] arr) {
        int n=arr.length,m=1;
        HashSet<Integer> hs = new HashSet<Integer>(); 
        for (int i = 0; i < n; i++) 
        { 
            if (m < arr[i]) 
                hs.add(arr[i]); 
            else if (m == arr[i]) 
            { 
                m = m + 1; 
                while (hs.contains(m)) 
                { 
                    hs.remove(m); 
                    m = m + 1; 
                } 
            } 
        } 
        return m; 
    }
}
