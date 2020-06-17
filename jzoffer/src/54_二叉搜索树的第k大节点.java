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


//二叉搜索树中序遍历的逆序
/*
 - 算法：
    - 终止条件： 当节点 root 为空（越过叶节点），则直接返回；
    - 递归右子树： 即 dfs(root.right) ；
    - 三项工作：
      - 提前返回： 若 k=0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
      - 统计序号： 执行 k=k−1 （即从 k 减至 0 ）；
      - 记录结果： 若 k=0 ，代表当前节点为第 k 大的节点，因此记录 res=root.val ；
    - 递归左子树： 即 dfs(root.left) ；
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
