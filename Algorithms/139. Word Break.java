/*
https://leetcode.com/problems/word-break/
*/

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.*/

/*Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

Note that you are allowed to reuse a dictionary word.
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null){
            return true;
        }
        Set<String> set = new HashSet<>(wordDict);
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j >= 0; j--){
                if(f[j] && set.contains(s.substring(j, i+1))){
                    f[i+1] = true;
                }
            }
        }
        return f[s.length()];
    }
}