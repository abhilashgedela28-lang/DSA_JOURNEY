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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int n = 0;
        while(temp!= null){
            n++;
            temp = temp.next;
        }
        if(n <= 2){
            return ans;
        }
        temp = head.next;
        ListNode prev = head;
        int count = 1;
        while(temp.next != null){
            if((prev.val > temp.val && temp.val < temp.next.val)||
            (prev.val < temp.val && temp.val > temp.next.val)){
                list.add(count);
            }
            count++;
            prev = temp;
            temp = temp.next;
        }
        int min = n;
        int max = -1;
        for(int i = 0;i<list.size()-1;i++){
            min = Math.min(list.get(i+1)-list.get(i),min);
        }
        if(list.size() >=2){
            ans[0] = min;
            ans[1] = list.get(list.size()-1) - list.get(0);
        }
        return ans;

    }
}