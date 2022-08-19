//55.1 - 二叉树的深度


//递归：深度 = 1 + max(左子，右子);
//0 ms/100.00%; 40.7 MB/98.09%
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
    public int maxDepth(TreeNode root) {
        //递归出口
        if(root==null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}


//三元运算符简化代码：
public class Solution {
    public int TreeDepth(TreeNode root) {
        return root==null?0:1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
		//对根结点是否为空进行判断
		//根结点为空，则深度为0；根结点不为空，则取左右子树深度中的较大值并加1得到二叉树深度
		//求左右子树的深度时，可以进行递归。
    }
}
