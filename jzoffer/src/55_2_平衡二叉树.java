//55.2 - 平衡二叉树
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
 */a
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



//自底向上：1ms，击败99.92%的用户
//当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
class Solution {
    public boolean isBalanced(TreeNode root) {
        //为-1，说明不是平衡树；当不为-1时，说明是平衡树
        return depth(root) != -1;
    }

    private int depth(TreeNode root){
        //判空：结点为null时，返回0
        if(root==null) return 0;

        //定义左右子树的高度并调用depth函数求值
        int left = depth(root.left);
        if(left==-1) 
            return -1;
        
        int right = depth(root.right);
        if(right==-1)
            return -1;
        
        //当左右子树都符合平衡树时，返回计算结果
        return Math.abs(left-right)<2 ? 1+Math.max(left, right) : -1;
    }
}
