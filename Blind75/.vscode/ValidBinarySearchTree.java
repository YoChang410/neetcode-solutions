//passed

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, -1001, 1001);
    }
    public boolean helper(TreeNode current, int low, int high){

        if(current == null) return true;

        if(current.val >= high || current.val <= low) return false;

        return (helper(current.left, low, current.val) && helper(current.right, current.val, high));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}