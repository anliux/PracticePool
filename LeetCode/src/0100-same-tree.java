//0100-相同的树
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
//思路：判空；判根节点值；调用本体判断左节点和右节点
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //判空：针对空与不空的各种情况进行判断
        if(p==null && q==null) 
            return true; //全空相等
        else if(p==null || q==null) 
            return false; //排除全空下，仅一空为真，全不空为假；一空一不空返回false
        else if(p.val != q.val)
            return false; //排序不相等情况，剩下为相等
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//优化代码：
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) 
            return true; 
        else if(p!=null && q!=null && p.val==q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false; 
    }
}



//迭代：？
//思路：从根开始，每次迭代将当前结点从双向队列中弹出。然后判断：非空且值相等时，压入子结点
//注：代码太多了，用递归就好
