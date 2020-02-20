//0112-路径总和
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
//算法：判空；更新sum值；当子树为空且sum==0时为真；否则继续调用本体函数判断子树的情况。
//  - 注：子树判断为“双或”，即只要存在任一子树符合即可为真
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //判空：根结点为空时返回false
        if(root==null) return false;

        //否则，更新sum的值
        sum = sum - root.val;

        //判断子树的情况：左右子树都为空时，判断此时的sum是否为0，为0则true
        if(root.left == null && root.right == null)
            return (sum==0);

        //否则：调用本体函数判断左右子树的情况，且左右子树有任一符合时，返回true
        return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));
    }
}
