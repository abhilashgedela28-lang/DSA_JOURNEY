/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        post(root,ans);
        return ans;
        
    }

    public void post(Node node, List<Integer> ans){
        if(node == null){
            return ;
        }

        ans.add(node.val);
        for(int i = 0;i<node.children.size();i++){
            post(node.children.get(i),ans);
        }
    }
}