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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();

            int sum = 0;
            for(int i = 0;i<size;i++){
                TreeNode current = q.poll();
                sum += current.val;

                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
            list.add(sum);
        }
        int ind = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<list.size();i++){
            if(list.get(i) > max){
                max = list.get(i);
                ind = i;
            }
        }
        return ind+1;
    }
}