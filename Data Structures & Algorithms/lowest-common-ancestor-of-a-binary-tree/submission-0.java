class Solution {
    List<TreeNode> list1=new ArrayList<>();
    List<TreeNode> list2=new ArrayList<>();
    public boolean traverse(TreeNode root,TreeNode p)
    {
      if(root==null) return false;
      list1.add(root);
      if(root==p)
      {    
        return true;
      }
     
        boolean f1=   traverse(root.left,p);
        boolean f2=   traverse(root.right,p);
        if(f1==true || f2==true) return true;
        list1.remove(list1.size()-1);
        return false;
    }
     public boolean traverse2(TreeNode root,TreeNode p)
    {
      if(root==null) return false;
      list2.add(root);
      if(root==p)
      {    
        return true;
      }
     
        boolean f1=   traverse2(root.left,p);
        boolean f2=   traverse2(root.right,p);
        if(f1==true || f2==true) return true;
        list2.remove(list2.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean n1=traverse(root,p);
        boolean n2=traverse2(root,q);
         int i=1;
        for( ;i<list1.size() && i<list2.size();i++)
        
          {
            if(list1.get(i)!=list2.get(i))
            {
                break;
            }
          }
              return list1.get(i-1) ;

    }

}