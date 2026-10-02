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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Long> list = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();

            long sum = 0;
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
        Collections.sort(list);
        int n = list.size();
        Collections.reverse(list);
        System.out.println(list);
        if(k > n){
            return -1;
        }
        return list.get(k-1);
    }
}