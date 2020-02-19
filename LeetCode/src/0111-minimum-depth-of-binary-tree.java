//0111-二叉树的最小深度
//思路：dfs(递归，迭代); bfs


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 


//dfs递归：0ms，击败100%的用户
//算法：首先判空；其次返回调用本体的左右子树的高，取得min值，并且+1后返回
//     - 判空：根结点为null时返回0，根结点的左右子结点全为null时返回1（仅一子树为空时，返回>1，需要再判断）
class Solution {
    public int minDepth(TreeNode root) {
        //规律：树的最小深度 = 1 + min(左子树的深度，右子树的深度)

        //判空：根结点为null时返回0，根结点的左右子结点全为null时返回1
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;

        //定义最小深度min，递归调用本体函数传入子结点，并取最小值
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(minDepth(root.left), min);
        }
        if(root.right != null){
            min = Math.min(minDepth(root.right), min);
        }

        //返回值需要在上面判断的基础上，再+1，即加上根结点
        return 1 + min;
    }
}



//其余两种方法略
