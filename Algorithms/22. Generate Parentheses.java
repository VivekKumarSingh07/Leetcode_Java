//https://leetcode.com/problems/generate-parentheses/description/

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

//For example, given n = 3, a solution set is:

//  [
//    "((()))",
//    "(()())",
//    "(())()",
//    "()(())",
//    "()()()"
//  ]

//Solution

class Solution {
    private List<String> result;

    public List<String> generateParentheses(int n) {
        result = new ArrayList<>();
        generateParenthesis("", 0, 0, n);
        return result;
    }

    private void generateParenthesis(String s, int open, int closed, int n) {
        if (closed > open || closed > n || open > n) {
            return;
        }

        if (open == n && closed == n) {
            result.add(s);
        } else {
            generateParenthesis(s + "(", open + 1, closed, n);
            generateParenthesis(s + ")", open, closed + 1, n);
        }
    }
}