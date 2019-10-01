// https://leetcode.com/problems/merge-two-sorted-lists/
// Merge two sorted linked lists and return it as a new list. The new list should be made by
// splicing together the nodes of the first two lists.

// Example:

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    if (l1 == null && l2 == null)
      return null;

    ListNode newList = new ListNode(0);
    ListNode newListHead = newList;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        newList.next = l1;
        l1 = l1.next;
      } else {
        newList.next = l2;
        l2 = l2.next;
      }
      newList = newList.next;
    }

    if (l1 != null)
      newList.next = l1;

    if (l2 != null)
      newList.next = l2;

    return newListHead.next;
  }
}