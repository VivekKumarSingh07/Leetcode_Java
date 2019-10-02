// https://leetcode.com/problems/palindrome-linked-list/
// Given a singly linked list, determine if it is a palindrome.

// Example 1:

// Input: 1->2
// Output: false
// Example 2:

// Input: 1->2->2->1
// Output: true
// Follow up:
// Could you do it in O(n) time and O(1) space?

class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head, reverse = null;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    if (fast != null)
      slow = slow.next;

    slow = reverse(slow);
    fast = head;

    while (slow != null) {
      if (fast.val != slow.val) {
        return false;
      }
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}