//34. 二叉树中和为某一值的路径



//回溯-状态重置：1 ms/99.97%; 41.6 MB/72.88%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //初始化为全局变量
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();//共用path

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return res;
    }

    public void recur(TreeNode root, int tar){
        //判空: 递归出口
        if(root == null)
            return;
        
        //如果添加：tar讲减去所结点对应的值
        path.add(root.val);
        tar -= root.val;

        //当路径结点和为tar，且已走到叶节点时：添加当前path当结果res中，注意需要新建
        if(tar==0 && root.left==null && root.right==null)//叶节点+
            res.add(new LinkedList(path));
        
        //递归左右结点
        recur(root.left,tar);
        recur(root.right,tar);

        //回溯，状态重置： remove 和 add是成对出现的, 若是前面add最后就需要remove
        path.removeLast();
    }
}
