class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d <= 0) return null;
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        return dfs(root, 1, v, d);
    }
    
    private TreeNode dfs(TreeNode root, int curr, int v, int d) {
        if (root == null) return root;
        if (curr == d - 1) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        } else {
            root.left = dfs(root.left, curr + 1, v, d);
            root.right = dfs(root.right, curr + 1, v, d);
        }
        return root;
    }
}
