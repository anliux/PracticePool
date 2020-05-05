//28-对称的二叉树
//思路：递归；迭代



//递归：0ms，击败100%的用户
/*
    - 算法：
      - 主体函数：判空；调用镜像函数。
      - 镜像函数：参数(root,root)
        - 判空：全为空时，返回true；
        - 判符合：当全不为空，且结点值相等时，返回子节点调用：注意左左对右右，左右对右左。
        - 否则：返回false。    
*/
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
    public boolean isSymmetric(TreeNode root) {
        //判空
        if(root == null)
            return true;
        
        //调用镜像函数
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right){
        //全为空，返回true
        if(left==null && right==null)
            return true;

        //全不为空且值相等时，递归调用
        else if(left!=null && right!=null && left.val==right.val)
            return isMirror(left.left, right.right) && isMirror(left.right,right.left);
        
        //否则，返回false
        else 
            return false;
    }
}
