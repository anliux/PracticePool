//55.1 - 二叉树的深度
//递归。从根结点开始分析不同情况下二叉树的深度，寻找规律。

public class Solution {
    public int TreeDepth(TreeNode root) {
        return root==null?0:1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }
}