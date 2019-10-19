// https://leetcode.com/problems/implement-strstr/

// Returns 0 if the length of needle is 0, otherwise returns the position of needle in haystack string
// -1 if needle is not found, a proper integer if needle is found.

public class haystack {
    int strStr (String haystack, String needle) {
        return (needle.length() != 0)?haystack.indexOf(needle):0;
    }
}
