//03-数组中重复的数字
//思路：集合；数组交换
//注意：异常判断；阈值设置；交换在while循环内。
//注：牛客和力扣的本题参数和返回值类型不同，前一个是力扣，返回int，后一个是牛客，返回boolean


//集合：7ms，击败38%的用户
//算法：定义集合；遍历数组：将数组元素存入集合，当无法存入时，返回当前元素；返回-1。
class Solution {
    public int findRepeatNumber(int[] nums) {
        //定义集合
        Set<Integer> set = new HashSet<>();

        //遍历数组元素并将元素添加到集合，如果添加失败，就返回该元素
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i]))
                return nums[i];
        }

        //返回非法的-1表示没有找到
        return -1;
    }
}



//数组交换
//算法：判空；遍历数组：如果不等，判断重复，交换；返回false
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
