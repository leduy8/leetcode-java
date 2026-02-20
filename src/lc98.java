package src;

//A valid BST is defined as follows:
//- The left subtree of a node contains only nodes with keys strictly less than the node's key.
//- The right subtree of a node contains only nodes with keys strictly greater than the node's key.
//- Both the left and right subtrees must also be binary search trees.

public class lc98 {
    public static void main(String[] args) {
    }

    public static class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode root, long minimum, long maximum) {
        if (root == null) return true;

        if (!(root.val > minimum && root.val < maximum)) return false;

        return valid(root.left, minimum, root.val) && valid(root.right, root.val, maximum);
    }
}
