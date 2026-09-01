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

public class MaxDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }
    public int depth(TreeNode node, int d){
        if(node == null)return d;
        else return Math.max(depth(node.left, d+1), depth(node.right, d+1));
    }
}
