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
    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        t(root,ans);
        int max = 0;
        for(int i =0;i<ans.size();i++){
            map.put(ans.get(i),map.getOrDefault(ans.get(i),0)+1);
            max  = Math.max(max,map.get(ans.get(i)));
        }
        ans.clear();
        for(int key:map.keySet()){
            if(map.get(key) == max){
                ans.add(key);
            }
        }
        int[] arr = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }

    public void t(TreeNode node, List<Integer> ans){
        if(node == null){
            return ;
        }
        ans.add(node.val);
        t(node.left,ans);
        t(node.right,ans);
    }
}