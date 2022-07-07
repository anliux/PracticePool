/*
151. 翻转字符串里的单词
与剑指：08-重建二叉树 一样
思路：递归地构建二叉树
注意：将由前序和中序重构二叉树的方法正确地转换为代码形式。
*/

//递归：2ms，击败56.87%的用户
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
    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
    int[] preorder;//保留的先序遍历，方便递归时依据索引查看先序遍历的值

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        //注意：索引值作为值，元素值作为key方便查找
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        /* 三个参数值：
            pre_root: 当前根的索引；
            in_left: 递归树的左边界，即数组左边界；
            in_right: 递归树的右边界，即数组右边界
        */
        return recur(0,0,preorder.length-1);
    }

    TreeNode recur(int pre_root, int in_left, int in_right){
        //递归出口：首尾重叠结束，相等就是自己
        if(in_left>in_right){
            return null;
        }

        //获取root结点
        TreeNode root = new TreeNode(preorder[pre_root]);

        //获取在中序遍历中根节点所在索引，以方便获取左子树的数量
        int index = map.get(preorder[pre_root]);

        //开始递归获取左右子树: 递归到null为止
        /*
        左子树：
            根结点：前序的根 + 1
            左边界：原中序的左边界 in_left
            右边界：中序的根 - 1
        */
        root.left = recur(pre_root + 1, in_left, index - 1);

        /*
        右子树：
            根结点：当前根位置 + 左子树的数量 + 1
            左边界：中序的根 + 1
            右边界：原中序的右边界
        */
        root.right = recur(pre_root + (index - in_left) + 1, index + 1, in_right);

        //返回树
        return root;
    }
}
