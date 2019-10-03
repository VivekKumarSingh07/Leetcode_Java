// https://leetcode.com/problems/add-two-numbers/
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example:

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        if(l1 == null && l2 == null) {
            return null;
        }
        
        if(l1 == null) {
            l1 = new ListNode(0);
        }
        if(l2 == null) {
            l2 = new ListNode(0);
        }
        
        ans.val = l1.val + l2.val;
        
        if(ans.val > 9) {
            ans.val -= 10;
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else {
                l1.next.val++;
            }
        }
        
        ans.next = addTwoNumbers(l1.next,l2.next);
        
        
        
        
        return ans;
    }
}
