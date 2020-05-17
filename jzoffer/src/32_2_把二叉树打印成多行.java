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
/*
  - 算法：
    - 复杂度：时间O(n)，空间O(n)
    - 判空：当根节点为空，则返回空列表 [] ；
      - (注：根结点判空需要新建，因此可以转为先初始化，然后对根结点判非空)
    - 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
    - BFS 循环： 当队列 queue 为空时跳出；
      - 新建一个临时列表 tmp ，用于存储当前层打印结果；
      - 当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
        - 出队： 队首元素出队，记为 node；
        - 打印： 将 node.val 添加至 tmp 尾部；
        - 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
      - 将当前层结果 tmp 添加入 res 。
    - 返回值： 返回打印结果列表 res 即可。
    - 注意：内循环次数控制的for循环
      - 使用i--，让size()只在循环开始使用一次，使循环次数不受队列长度变化影响，妙啊！
      - 若i从0开始，使用i++，那么queue的size每一轮都在变，会导致错误。
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
