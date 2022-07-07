/*
08-重建二叉树

注意：将由前序和中序重构二叉树的方法正确地转换为代码形式。
*/

//递归：1ms，击败99.91%的用户
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




//其他代码展示：
import java.util.Arrays;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		//注：参数列表为前序和中序，递归时注意对应
        //数组长度为0时异常，或用于结束函数。
		if(pre.length == 0)
			return null;
		
		int rootVal = pre[0];

		//数组长度为1时新建结点
		if(pre.length == 1)
			return new TreeNode(rootVal);

		//找到root，确定好前序和中序中左子树和右子树的范围
		TreeNode root = new TreeNode(rootVal);
		int rootIndex = 0; //定义中序中root结点的索引值
		for (int i=0; i<in.length; i++) 
			//遍历中序，当找到root时结束并返回root在中序中的索引值。
		{
			if(rootVal == in[i])
			{
				rootIndex = i;
				break;
			}
		}

		//递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //注意：Arrays.copyOfRange(int[],start,end)是[)的区间，及左闭右开
		//注意：递归函数的参数列表为前序和中序，因此所赋值仍是前序和中序，看晕的自行画图看示例就一目了然了。
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length), Arrays.copyOfRange(in,rootIndex+1,in.length));

		return root;
    }
}
