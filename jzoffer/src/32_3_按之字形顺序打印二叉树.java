//32.3-按之字形顺序打印二叉树
//思路：层序遍历+双端队列；奇偶分离；层序遍历+倒序。



//层序遍历+双端队列：1ms1 ms/96.76%; 41.4 MB/67.71%
/*
   - 算法流程：
      - 特例处理： 当树的根节点为空，则直接返回空列表 [] ；
      - 初始化： 打印结果空列表 res ，包含根节点的双端队列 deque ；
      - BFS 循环： 当 deque 为空时跳出；
      - 新建列表 tmp ，用于临时存储当前层打印结果；
        - 当前层打印循环： 循环次数为当前层节点数（即 deque 长度）；
          - 出队： 队首元素出队，记为 node；
          - 打印： 若为奇数层，将 node.val 添加至 tmp 尾部；否则，添加至 tmp 头部；
          - 添加子节点： 若 node 的左（右）子节点不为空，则加入 deque ；
        - 将当前层结果 tmp 转化为 list 并添加入 res ；
      - 返回值： 返回打印结果列表 res 即可；
      - 注：对于奇偶数层的判断是根据结果列表的长度，因为每次添加一行，因此可以用来判断是哪一行。
        - 初始化会添加根结点；
        - 第二次是偶数行，此时结果列表res的长度为1，是奇数，对应的下一行是偶数行，应该添加元素在头部；
        - 第三次是奇数行，此时结果列表res的长度为2，是偶数，对应的下一行的奇数行，应该正常添加元素，即在尾部添加；
        - 综上：size为奇数时，addFirst；size为偶数时，addLast。

*/
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
        //初始化
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        //判空
        if(root != null)
            queue.add(root);

        //循环：当queue为空时终止循环
        while(!queue.isEmpty()){
            //建立临时列表存储每层元素
            LinkedList<Integer> tmp = new LinkedList<>();//注：左边类型写为List会报错(?）

            //内循环
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                
               //根据开始两次辅助判断：当size()=0时，加入根结点，应顺序add；当size=1时，加第二行，应addFirst 
               if(list.size() % 2 == 1)//添加偶数行：加在队首
                    tmp.addFirst(node.val);
                else//添加奇数行：加在队尾
                    tmp.addLast(node.val);
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            //添加临时列表到结果列表
            list.add(tmp);
        }

        //返回结果
        return list;
    }
}



//层序遍历+双端队列+奇偶分离
/*

    - 分析：
      - 方法一代码简短、容易实现；但需要判断每个节点的所在层奇偶性，即冗余了 N 次判断。
      - 通过将奇偶层逻辑拆分，可以消除冗余的判断。
    - 算法流程：
      - 与方法一对比，仅 BFS 循环不同。
      - BFS 循环： 循环打印奇 / 偶数层，当 deque 为空时跳出；
        - 打印奇数层： 从左向右 打印，先左后右 加入下层节点；
        - 若 deque 为空，说明向下无偶数层，则跳出；
        - 打印偶数层： 从右向左 打印，先右后左 加入下层节点；

*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) deque.add(root);
        while(!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if(deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if(node.right != null) deque.addFirst(node.right);
                if(node.left != null) deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
    }
}
