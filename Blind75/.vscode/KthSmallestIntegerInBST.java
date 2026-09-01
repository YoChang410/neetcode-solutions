//passed

class Solution {
    int counted = 0;
    int smallestVal = -1;
    public int kthSmallest(TreeNode root, int k) {
       helper(root, k);
       return smallestVal;
    }
    public void helper(TreeNode node, int k){
        
        if(node.left != null) helper(node.left, k);
        counted++;
        if(counted == k && smallestVal == -1){
            smallestVal = node.val;
        }
        if(node.right != null) helper(node.right,k);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
