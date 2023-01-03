public class _236_LowestAncestor {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right!= null&&left!=null) {
            return root;
        }
        return left!=null?left:right;
    }
}
