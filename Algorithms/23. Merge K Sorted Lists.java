//https://leetcode.com/problems/merge-k-sorted-lists/description/

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

//Example:

//Input:
//  [
//    1->4->5,
//    1->3->4,
//    2->6
//  ]

//Output: 1->1->2->3->4->4->5->6

//Solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = new ListNode(-1);
        ListNode current = head;
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, (l1, l2) -> l1.val - l2.val);
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }

        ListNode n = null;
        while ((n = pq.poll()) != null) {
            current.next = n;
            current = current.next;
            if (n.next != null) {
                pq.add(n.next);
            }
        }

        return head.next;
    }
}