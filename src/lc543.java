package src;


public class lc543 {
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

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0; // Empty subtree has height 0

        int l = dfs(root.left);  // Height of left subtree
        int r = dfs(root.right); // Height of right subtree

        res = Math.max(res, l + r); // Diameter passing through this node

        return 1 + Math.max(l, r); // Height of current subtree
    }
}
