/*
08-二叉树的下一个结点

注意：没有右子且不是其父的左子的情况比较复杂，但是代码体现比较简单，只是循环。
*/

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)	//判空
			return null;
		if(pNode.right!=null) //当结点的右不为空时
		{
			pNode = pNode.right; //把右孩子作为当前结点考虑，避免引入新参数。 
			while(pNode.left!=null) //若右孩子的左结点存在，返回之。
				pNode = pNode.left;
			return pNode; //若右孩子的左不存在，返回右孩子本身。
		}
		else //当结点的右为空时
		{
			while(pNode.next!=null) //若当前结点非根节点
			{
				if(pNode == pNode.next.left) //判断该结点是否是其父的左子
					return pNode.next; //是则返回父
				pNode = pNode.next; //否则回溯一层并重复进行一次相同的判断
			}
		}
		return null;
    }
}
