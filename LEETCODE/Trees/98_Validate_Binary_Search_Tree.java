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
    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        for(int i = 0;i<ans.size()-1;i++){
            if(ans.get(i) >= ans.get(i+1)){
                return false;
            }
        }
        return true;
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