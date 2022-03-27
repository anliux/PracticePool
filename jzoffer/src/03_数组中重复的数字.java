//03-数组中重复的数字
//思路：集合；数组交换
//注意：异常判断；阈值设置；交换在while循环内。
//注：牛客和力扣的本题参数和返回值类型不同，2是力扣，返回int，13是牛客，返回boolean



//遍历：两层循环对比所有数组元素，可AC，但时间复杂度高 (牛客)
//思路：第一层循环依次选取一个锚点数字，第二层循环遍历剩下的数字，当找到相同的两个数字，退出循环，返回正确的结果。
//注：没有进行越界等其他判断，较粗糙
import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组 
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        // write code here
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if (numbers[i] == numbers[j])
                   return numbers[i];
            }
        }
        return -1;
    }
}



//集合：7ms，击败38%的用户 (力扣)
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



//数组交换 (牛客)
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
