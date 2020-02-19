//0110-平衡二叉树
//思路：自顶向下；自底向上



//自顶向下：2ms，击败17.5%的用户
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        //判空：为空符合平衡
        if(root==null) return true;

        //平衡：子树高度差<2，并且子树也是平衡树
        return Math.abs( height(root.left) - height(root.right) ) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode root){
        //判空：空时返回-1
        if(root==null) return -1;

        //递归计算高度
        return 1 + Math.max(height(root.left), height(root.right));
    }
}



//自底向上：
