class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res; 
    }

    static void postOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postOrder(node.left, res);     // Left subtree
        postOrder(node.right, res);    // Right subtree
        res.add(node.val);             // Visit root
    }
}