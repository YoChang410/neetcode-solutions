//passed

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
import java.util.List;
import java.util.ArrayList;

class Solution {

    //height of the tree is the size of this list.
    List<List<Integer>> ansList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return ansList;
    }

    public void helper(TreeNode currentNode, int heightIndex){

        if(currentNode == null)return;

        if(ansList.size() <= heightIndex){
            ansList.add(new ArrayList<Integer>());
        }

        helper(currentNode.left, heightIndex + 1);
        helper(currentNode.right, heightIndex + 1);

        ansList.get(heightIndex).add(currentNode.val);
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