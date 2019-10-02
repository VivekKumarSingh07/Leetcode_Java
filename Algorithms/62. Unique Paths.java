//https://leetcode.com/problems/unique-paths/

/*
A robot is located at the top-left corner of a m x n grid .

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid .

How many possible unique paths are there?

Note: m and n will be at most 100.


Example 1 :
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right


Example 2 :

Input: m = 7, n = 3
Output: 28


*/


//Solution  using dynamic programming

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //fill all rows with 1
        for(int[] row : dp){
            Arrays.fill(row,1);
        }
        //calculate number of unique paths for a given position
        for(int i = 1; i < dp.length; i++){
            for(int j =1; j <dp[i].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        //unique paths to the end
        return dp[m-1][n-1];
    }
}
