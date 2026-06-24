class Solution {
    int max = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,0,ans);
        return ans;
    }
    public void helper(TreeNode root, int curr, List<Integer> lt){
        if(root == null){
            return;
        }
        if(max<curr){
            lt.add(root.val);
            max = curr;
        }
        helper(root.right,curr+1,lt);
        helper(root.left,curr+1,lt);

    }
}