//0104-二叉树的最大深度
//思路：递归；迭代

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



//递归：0ms，击败100%的用户
//规律：树的高度 = 1 + max(左子树的高，右子树的高)
//算法：首先判空；其次返回调用本体的左右子树的高，取得max值，并且+1后返回
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}



//迭代：略
