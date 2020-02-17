//107-二叉树的层次遍历2
//思路：同102题，只需在结果返回前反转集合（递归）



//递归耗时：2ms，击败32%的用户
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
    //定义二维数组lsits
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //判空
        if(root == null) return levels;

        //调用helper函数
        helper(root, 0);

        //反转并返回
        Collections.reverse(levels);
        return levels;
    }
}
