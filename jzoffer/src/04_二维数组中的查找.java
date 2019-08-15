/*
04-二维数组中的查找

注意：阈值设置，不要太大防止角标越界，不要太小防止取不到所有。
*/
public class Solution {
    public boolean Find(int target, int [][] array) {
		if(array==null || array.length<=0 || array[0].length<=0) //排除空指针等异常
			return false;
		int rows = array.length, cols = array[0].length; //行列数赋值给变量以便使用
		int row = 0, col = cols-1; //从右上角开始
		while(row<rows && col>=0) //行递增，列递减，在数组范围内时保持循环
		{
			if(target == array[row][col]) //当右上角等于目标，找到
				return true;
			else if(target<array[row][col]) //当右上角大于目标，缩小范围到左侧
				col--;
			else //当右上角小于目标，缩小范围到下侧
				row++;
		}
		return false;
    }
}
