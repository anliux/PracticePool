//0102-二叉树的层次遍历
//思路：dfs，bfs，递归，迭代

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



//递归：1ms，击败98%的用户
//思路：整体步骤：进入helper函数后：判断是否新建level（二维数组），添加结点值，子节点非空时调用helper(必要判断，因为添加右结点时不用新建level)
class Solution {
    //定义二维数组levels
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    //定义helper(node, level)，参数是当前节点和节点的层次。
    private void helper(TreeNode node, int level){
        //如果当前层数与二维数组长度一致，则新建二维数组元素并添加
        if(levels.size()==level) 
            levels.add(new ArrayList<Integer>());
        
        //定位层数level，并添加当前结点到二维数组
        levels.get(level).add(node.val);

        //处理子结点：非空时调用helper函数
        if(node.left != null)
            helper(node.left, level+1);
        if(node.right != null)
            helper(node.right, level+1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        //判空
        if(root == null) return levels;

        //调用helper函数并返回levels
        helper(root, 0);
        return levels;
    }
}



//迭代：略
