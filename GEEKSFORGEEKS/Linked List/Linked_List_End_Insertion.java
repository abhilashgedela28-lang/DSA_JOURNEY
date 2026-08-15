/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node temp = head;
        Node extra = new Node(x);
        if(temp == null){
            return extra;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = extra;
        return head;
    }
}