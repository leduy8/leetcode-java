package src;

public class lc1448 {
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

    public int goodNodes(TreeNode root) {
        // Start DFS with the root value as the initial maximum
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxSoFar) {
        // If the node is null, there are no good nodes in this path
        if (root == null) return 0;

        int count = 0;

        // A node is "good" if its value is greater than or equal
        // to the maximum value seen on the path from the root
        if (root.val >= maxSoFar) count = 1;

        // Update the maximum value for the path before exploring children
        maxSoFar = Math.max(maxSoFar, root.val);

        // Recursively count good nodes in left and right subtrees
        count += dfs(root.left, maxSoFar);
        count += dfs(root.right, maxSoFar);

        return count;
    }
}
