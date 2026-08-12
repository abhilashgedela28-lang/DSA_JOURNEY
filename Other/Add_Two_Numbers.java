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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(temp1 != null && temp2 != null){
            
            int sum = temp1.val + temp2.val + carry;
            carry = sum /10;

            curr.next = new ListNode(sum%10);
            curr = curr.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        ListNode v ;
        if(temp1 == null){
            v = temp2;
        }
        else{
            v = temp1;
        }
        while(v != null){
            int sum = v.val + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            v = v.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
    }

    
}
