/*
08-重建二叉树

注意：将由前序和中序重构二叉树的方法正确地转换为代码形式。
*/

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