// https://leetcode.com/problems/valid-anagram 

// Given two strings s and t , write a function to determine if t is an anagram of s.

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?


public class Solution {

    public boolean isAnagram(String s, String t) {
        return Arrays.equals(sortString(s), sortString(t));
    }

    private Integer[] sortString(String s) {
        return s.chars().sorted().boxed().toArray(Integer[]::new);
    }

}

