import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/

//        Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//        Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
//        The order of output does not matter.
//
//        Example 1:
//
//        Input:
//        s: "cbaebabacd" p: "abc"
//
//        Output:
//        [0, 6]
//
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
//        Example 2:
//
//        Input:
//        s: "abab" p: "ab"
//
//        Output:
//        [0, 1, 2]
//
//        Explanation:
//        The substring with start index = 0 is "ab", which is an anagram of "ab".
//        The substring with start index = 1 is "ba", which is an anagram of "ab".
//        The substring with start index = 2 is "ab", which is an anagram of "ab".

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        int size = p.length();
        String sortedTarget = sortString(p);
        int end = s.length() - size;
        for (int i = 0; i <= end; i++) {
            String sortedSubstring = sortString(s.substring(i, i + size));
            if (sortedSubstring.equals(sortedTarget)) {
                result.add(i);
            }
        }
        return result;
    }

    private String sortString(String s) {
        char[] x = s.toCharArray();
        Arrays.sort(x);
        return String.valueOf(x);
    }

}

