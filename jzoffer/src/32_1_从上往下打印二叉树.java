//32.1-从上往下打印二叉树
//思路：层序遍历，广度优先遍历，队列



//耗时：1 ms/97.62%; 41 MB/91.61%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
  - 算法：
    - 复杂度：时间O(n)，空间O(n)
    - 判空：当根结点为空时，返回空列表[]（注：根据返回值类型设置）
    - 初始化结果列表list为空列表，辅助队列queue，并将根结点存入辅助队列；
    - 循环：当队列 queue 为空时跳出
      - 出队：队首元素出队，记为 node；
      - 打印：将 node.val 添加至列表 tmp 尾部；
      - 添加子节点：若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
    - 返回值：新建结果数组res，遍历list并存入res，然后返回。
*/

class Solution {
    public int[] levelOrder(TreeNode root) {
        //判空：根结点为空时，返回空数组
        if(root==null)
            return new int[0];

        //初始化结果列表和辅助队列
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //循环：直到辅助队列为空
        while(!queue.isEmpty()){
            //出队列 -- 对应结点的值添加到列表 -- 对应结点的子节点入队列
            TreeNode node = queue.poll();
            list.add(node.val);

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }

        //遍历获取结果列表的元素并存入结果数组，然后返回结果数组
        int [] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
