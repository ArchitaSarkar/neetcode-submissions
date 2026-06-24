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

    // Helper to find the minimum value node in a subtree (inorder successor)
    public TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Recursive BST deletion
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Traverse left or right depending on key
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            TreeNode successor = inorderSuccessor(root.right);  // or use inorder predecessor
            root.val = successor.val;  // Replace value
            root.right = deleteNode(root.right, successor.val); // Delete the duplicate node
        }
        return root;
    }
}
