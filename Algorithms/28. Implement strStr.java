// https://leetcode.com/problems/implement-strstr/

// Returns 0 if the length of needle is 0, otherwise returns the position of needle in haystack string
// -1 if needle is not found, a proper integer if needle is found.

// Example -
// strStr("hello", "ll") will return 2
// strStr("hello", "") will return 0
// strStr("leet", "a") will return -1

public class haystack {
    int strStr (String haystack, String needle) {
        return (needle.length() != 0)?haystack.indexOf(needle):0;
    }
}
