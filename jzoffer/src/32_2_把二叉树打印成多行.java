//32.2-把二叉树打印成多行
//思路：层序遍历+bfs用队列实现；每层打印一行用两层循环实现。



//耗时：1ms，击败95%的用户
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //初始化：
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //判空
        if(root != null)
            queue.add(root);

        //循环：直到辅助队列为空
        while(! queue.isEmpty()){
            //新建一个临时列表 tmp ，用于存储当前层打印结果
            List<Integer> tmp = new ArrayList<>();

            //内层循环：循环次数为当前层节点数（即队列 queue 长度）
            for(int i = queue.size(); i > 0; i--){
                //出队，打印，添加子节点
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            //将tmp存入结果列表list
            list.add(tmp);
        }

        //返回结果
        return list;
    }
}
