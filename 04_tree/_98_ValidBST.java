
public class _98_ValidBST {
    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * <p>
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode treeNode) {
    /**
     * 思路：二叉搜索树特点，中序遍历数组为升序,遍历的时候判断当前值是否比前一个值大
     * 中序遍历： 左 - 根 - 右
     */
        if (treeNode == null) {
            return true;
        }
        //访问左子树
        if(!isValidBST(treeNode.left)){//如果左子树不是那就不是
            return false;
        }
        //判断判断当前值是否比前一个值大
        if(treeNode.val<=pre){
            return  false;
        }
        pre= treeNode.val;
        //访问右子树
        return isValidBST(treeNode);
    }
}
