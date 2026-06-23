/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        List<List<Node>> list=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        List<Node> l=new ArrayList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
            Node curr=q.poll();
            if(curr==null)
            {
                list.add(new ArrayList<>(l));
               if(!q.isEmpty())
               {
                q.add(null);
                l=new ArrayList<>();
               }
            }
            else
            {
                l.add(curr);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }

        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).size()-1;j++)
            {
              list.get(i).get(j).next=list.get(i).get(j+1);
            }
            list.get(i).get(list.get(i).size()-1).next=null;
        }

        return root;
    }
}