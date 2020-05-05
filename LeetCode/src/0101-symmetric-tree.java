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
/*
    - 算法：
      - 主体函数：判空；调用镜像函数。
      - 镜像函数：参数(root,root)
        - 判空：全为空时，返回true；
        - 判符合：当全不为空，且结点值相等时，返回子节点调用：注意左左对右右，左右对右左。
        - 否则：返回false。
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //注：第一步判空，如果root==null，则为true。本题规定了范围因此省略
        if(root==null) return true;
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
