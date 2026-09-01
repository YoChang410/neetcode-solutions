import java.util.HashMap;
//passed

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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> positions = new HashMap<>();
        for(int i=0; i<inorder.length; ++i){
            positions.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1; i<preorder.length; ++i){
            TreeNode current = root;
            boolean vacancyFound = false;
            while(!vacancyFound){
                if(positions.get(preorder[i]) < positions.get(current.val)){
                    vacancyFound = current.left == null;
                    if(!vacancyFound) current = current.left;
                }
                else{
                    vacancyFound = current.right == null;
                    if(!vacancyFound) current = current.right;
                }
            }

            if(positions.get(preorder[i]) < positions.get(current.val)){
                current.left = new TreeNode(preorder[i]); 
            }else current.right = new TreeNode(preorder[i]);
        }
        return root;
    }
}