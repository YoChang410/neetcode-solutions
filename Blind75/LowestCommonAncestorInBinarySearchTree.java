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

public class LowestCommonAncestorInBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(!((root.val >= q.val && root.val <= p.val) || (root.val <= q.val && root.val >= p.val))){
            if(root.val > q.val)root = root.left;
            else root = root.right;
        }
        return root;
    }
}
