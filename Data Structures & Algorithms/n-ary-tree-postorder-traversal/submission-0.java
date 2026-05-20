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
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        dfs(list,root);
        return list;
        
    }

    public void dfs(List<Integer> list,Node root)
    {
        if(root==null) return;
        for(Node child: root.children)
        {
            dfs(list,child);
        }
        list.add(root.val);
    }
}