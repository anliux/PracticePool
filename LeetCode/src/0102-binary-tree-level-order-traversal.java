//0102-二叉树的层次遍历
//思路：dfs，bfs，递归，迭代；队列+两层遍历实现。

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



//两层遍历：1ms，击败90.76%的用户
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
        //初始化
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //判空
        if(root != null)
            queue.add(root);

        //循环
        while(!queue.isEmpty()){
            //设置临时列表
            List<Integer> tmp = new ArrayList<>();

            //内循环：以队列长度作为循环长度，并使用i--倒着循环
            for(int i = queue.size(); i > 0; i--){
                //出队 -- 打印 -- 添加子节点
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            //将临时列表添加到结果列表
            list.add(tmp);
        }

        //返回结果列表
        return list;
    }
}
