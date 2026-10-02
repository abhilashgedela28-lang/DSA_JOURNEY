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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        t(root,list);
        set.add(list.get(0));
        for(int i = 1;i<list.size();i++){
            if(set.contains(k-list.get(i))){
                return true;
            }
            set.add(list.get(i));
        }
        return false;
    }

    public void t(TreeNode node,List<Integer> list){
        if(node == null){
            return ;
        }
        list.add(node.val);
        t(node.left,list);
        t(node.right,list);
    }
}