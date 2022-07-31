//27-二叉树的镜像
//思路：递归；循环



//递归：0ms/100%; 39.1 MB/20.52%
/*
  - 递归：
    - 复杂度：时间O(n), 空间O(n)
    - 分析：先序遍历，并交换每个节点的左右子树，交换时递归；当root为null时，结束遍历并返回
    - 算法：
      - 判空：root为null时，返回null；
      - 交换root的左右子树，并递归；
        - 注1：交换和递归可以分开，也可以合起来；
        - 注2：root为叶子节点时，也符合，递归时，root为空，停止递归并返回；
      - 返回结果root。
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
    public TreeNode mirrorTree(TreeNode root) {
        //判空
        if(root == null)
            return null;//或return root;
        
        //交换root的左右子树，同时递归
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        //返回root结果
        return root;
    }
}



//循环实现：0ms/100%; 38.8 MB/65.44%
/*
  - 循环实现：
    - 复杂度：时间O(n), 空间O(n)
    - 分析：利用栈（或队列）遍历树的所有节点 node ，并交换每个 node 的左 / 右子节点。
    - 算法：
      - 判空：root为空时，返回null
      - 初始化栈，并将root根节点添加到栈；
      - 循环：当栈不为空时，循环
        - 弹出栈顶结点，并赋值给node变量，
        - 添加子节点：将弹出结点的左右子树入栈 -- 注意判空：当子树不为空时入栈；
        - 交换node结点的左右子树 -- 注：此处不必判空，叶子节点的两个子树null和null交换也没问题，不必特意加判空，增加代码复杂性；
      - 返回结果root
      - 注：栈相当于保存结点的名字，并设置一定的修改顺序，交换子节点的效果是直接反映在原二叉树里的。
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
    public TreeNode mirrorTree(TreeNode root) {
        //判空
        if(root == null) 
            return null;

        //创建并初始化一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        //循环：当栈不为空时循环 -- 注意不是以root不为null作为判断条件
        while(!stack.isEmpty()) {
            //弹出栈顶结点并赋值给变量node
            TreeNode node = stack.pop();

            //将node结点对应的左右子树入栈: 即所有非空结点进栈，在下次循环中作为node结点
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
            
            //交换node结点的左右子树
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

        //上述循环重新构建了以root为根结点的树，并返回结果
        return root;
    }
}
