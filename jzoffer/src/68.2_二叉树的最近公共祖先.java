//68.2 二叉树的最近公共祖先
//思路：DFS递归



//DFS递归:8ms/21.96%; 40.82MB/14.02%
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //判空
        if(root == null)
            return null;


        //当root为p或q时：直接返回root
        if(root == p || root == q)
            return root;

        //初始化左右子节点并递归赋值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //对左右子树的情况进行判断：

        //1.左右子树都不为空：即p q在当前root两侧，符合条件
        if(left !=null && right != null)
            return root;

        //2.左子树不为空：即p q都在左子树中
        if(left != null)
            return left;

        //3.右子树不为空：即p q都在右子树中
        if(right != null)
            return right;

        //其他情况：左右子树都为空时，返回null 
        return null;
    }
}
