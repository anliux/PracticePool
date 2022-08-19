//54 - 二叉搜索树的第k大节点
//思路：二叉搜索树的中序遍历：递增；逆序递减。


//二叉搜索树-倒序中序遍历：0ms/100%; 41 MB/86.05%
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
    //声明全局变量：
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        //全局k赋值
        this.k = k;

        //调用函数dfs， 并返回结果
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        //二叉搜索树的中序：递增；中序倒序：递减
        //递归出口：越过叶节点
        if(root == null)
            return;

        //右子树递归：
        dfs(root.right);

        //本节点的三项工作：判k；更新k；更新res
        if(k==0)
            return;
        k--;
        if(k==0)
            res = root.val;

        //左子树递归
        dfs(root.left);
    }
}
