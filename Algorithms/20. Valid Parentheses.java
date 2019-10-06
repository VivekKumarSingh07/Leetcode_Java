/*
https://leetcode.com/problems/valid-parentheses/submissions/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class Solution {
    class Node {
        public Node (char data, Node next){
            this.data = data;
            this.next = next;
        }
        char data;
        Node next;
    }
    class Stack {
        Node top;
        public char pop() {
            char tmp = top.data;
            top = top.next;
            return tmp;
        }
        public void push(char c) {
            top = new Node(c, top);
        }
        public boolean isEmpty() {
            return top == null;
        }
    }
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for(char c : s.toCharArray()) {
            switch(c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                break;
            }
        }
        return stack.isEmpty();
    }
}
