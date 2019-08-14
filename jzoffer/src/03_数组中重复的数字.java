/*
03-数组中重复的数字

注意：异常判断；阈值设置；交换在while循环内。
*/
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
		if (numbers==null || length<=0)//判断异常：空或长度为负
			return false;

		for (int i=0; i<length; i++)//判断异常：数字不在0~n-1内时
		{
			if(numbers[i]<0 || numbers[i]>=length)
				return false;
		}
		
		for (int i=0; i<length; i++)//遍历
		{
			while(numbers[i] != i)//当下标对应的数字与下标不等时进一步判断
			{
				if(numbers[i]==numbers[numbers[i]])//重复情况
				{
					duplication[0] = numbers[i];
					return true;
				}
				//否则进行交换
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;	
			}
		}
		return false;
    }
}