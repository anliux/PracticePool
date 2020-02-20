//0119-杨辉三角II
//思路：动态规划；公式法



//动态规划：2ms，击败67.3%的用户
//空间优化：倒序遍历，不用另外开辟存储空间
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //新建一维List，并初始化第一个元素为1
        List<Integer> cur = new ArrayList<>();
        cur.add(1);

        //遍历：外层从上到下，内层从右到左（从大到小）
        for(int i=1; i<=rowIndex; i++){ //需要取到第rowIndex层，因此包含等于
            //内层：从倒数第二个开始遍历，最后一位是1，循环结束后add
            for(int j=i-1; j>0; j--){ //不等于0，因为第一位永远是1，不需要更新为其他
                cur.set(j, cur.get(j-1)+cur.get(j));
            }
            cur.add(1); //这里补的1是每行最后一个位置的1，add是添加到末尾。
        }
        
        //返回最终结果
        return cur;
    }
}
