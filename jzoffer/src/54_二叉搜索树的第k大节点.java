//54 - 二叉搜索树的第k大节点
//思路：二叉搜索树的中序遍历：递增；逆序递减。



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
    int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.right);
        if(--k == 0)
            result = root.val;
        dfs(root.left);
    }
}
