//0101-对称二叉树
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
//同100题的递归思路：

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null)
            return true;
        else if(t1!=null && t2!=null && t1.val == t2.val) 
            return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        else
            return false;
    }
}



//迭代：
//注：代码太多了，用递归就好
