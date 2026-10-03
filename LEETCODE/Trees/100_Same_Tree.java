    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] arr = new boolean[1];
        traversal(p,q,arr);
        if(arr[0] == true){
            return false;
        }
        return true;
    }

    public void traversal(TreeNode node1,TreeNode node2,boolean[] arr){
        if((node1 == null && node2 != null) || (node1 != null && node2 == null)){
            arr[0] = true;
        }
        if(node1 == null || node2 == null){
            return ;
        }
        traversal(node1.left,node2.left,arr);
        if(node1.val != node2.val){
            arr[0] = true;
        }
        traversal(node1.right,node2.right,arr);
    }
}