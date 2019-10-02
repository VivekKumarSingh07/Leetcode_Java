//https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

//Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
//
//Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

//Example

//Example 1:
//
//Input: queries = ["cbd"], words = ["zaaaz"]
//Output: [1]
//Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
//Example 2:
//
//Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//Output: [1,2]
//Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] dp = new int[11];

        for (int i = 0; i < words.length; i++) {
            int freq = countOfSmallestLetter(words[i]);
            dp[freq - 1]++;
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] += dp[i + 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int freq = countOfSmallestLetter(queries[i]);
            ans[i] = dp[freq];
        }
        return ans;
    }

    private int countOfSmallestLetter(String s) {
        char smallest = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < smallest) {
                smallest = c;
                count = 1;
            } else if (c == smallest) {
                count++;
            }
        }
        return count;
    }
}
