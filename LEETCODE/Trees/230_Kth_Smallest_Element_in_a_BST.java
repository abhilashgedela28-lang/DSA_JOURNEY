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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans.get(k-1);
    }

    public void inorder(TreeNode node,List<Integer> ans){
        if(node == null){
            return ;
        }
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
    }
}