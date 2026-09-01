//passed
import java.util.*;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        ArrayList<Node> nodes = createGraph(root);

        int max = Integer.MIN_VALUE;
        for(Node node : nodes){
            max = Math.max(max, maxValue(node));
        }
        return max;
    }

    //max value finder methods
    public int maxValue(Node node){
        node.used = true;
        int max = node.val;
        for(Node adj : node.adj){
            if(!adj.used) max = Math.max(max, node.val+maxValue(adj));
        }
        node.used = false;
        return max;
    }

    //graph creation methods
    public ArrayList<Node> createGraph(TreeNode root){//creates a graph and returns a set with all nodes.
        ArrayList<Node> nodes = new ArrayList<Node>();
        createGraphHelper(nodes, null, root);
        return nodes;
    }
    public void createGraphHelper(ArrayList<Node> nodes, Node currentNode, TreeNode current){
        if(current == null)return;
        Node node = null, left = null, right = null;
        if(currentNode == null) node = new Node(current.val);
        else node = currentNode;
        if(current.left != null){
            left = new Node(current.left.val);
            node.adj.add(left);
            left.adj.add(node);
            createGraphHelper(nodes, left, current.left);
        }
        if(current.right != null){
            right = new Node(current.right.val);
            node.adj.add(right);
            right.adj.add(node);
            createGraphHelper(nodes, right, current.right);
        }
        if(currentNode == null)nodes.add(node);
        if(left != null)nodes.add(left);
        if(right != null)nodes.add(right);
    }
}

class Node{
    ArrayList<Node> adj = new ArrayList<Node>();
    int val;
    boolean used = false;
    public Node(int val){ this.val = val;}
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