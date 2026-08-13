/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//code in java

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode last = temp;
        ListNode prev = null;
        ListNode front;
        temp = temp.next;
        while(temp!= null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        int max = 0;
        while(prev != null){
            max = Math.max(prev.val+ head.val,max);
            prev = prev.next;
            head = head.next;
        }
        return max;

    }
}
