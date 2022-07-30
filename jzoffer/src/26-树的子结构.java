//26. 树的子结构
//递归：0ms/100%; 44.2 MB/5.14%

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {//遍历A树
        //判空：有任一树为空，都匹配失败，返回false
        if(A==null || B==null)
            return false;
        
        //三种匹配成功的情况：根结点匹配树B；树A的左子树作为根结点与树B匹配；树A的右子树作为根结点与树B匹配
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean recur(TreeNode A, TreeNode B){//判断匹配
        //匹配成功的一种情况：树B已经遍历完毕且没有false跳出
        if(B==null)
            return true;
        //匹配失败的两种情况：树A已经遍历完毕但没有找到；参数树A和B的根结点的值val不相等
        if(A==null || A.val!=B.val)
            return false;

        //以上情况都不符：即A.val==B.val，则递归继续对比子结点的匹配情况
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
