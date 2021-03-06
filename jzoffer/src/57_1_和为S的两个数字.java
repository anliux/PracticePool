//57.1 - 和为S的两个数字
//牛客题目规定使用ArrayList。其中的思想还是一样，主要是开始时new和中途添加add



//返回值类型为ArrayList的情况：
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        
		//创建ArrayList，并指定为Integer型
		ArrayList<Integer> list = new ArrayList<>();
        
        //第一步：判空
		if(array==null || array.length==0)
            return list;
        
		//定义首尾两个指针（或者索引值）
        int left = 0;
        int right = array.length-1;
        
        //循环：判停条件是两个指针left<right
		while(left<right){
            //定义和
			int total = array[left]+array[right];
            //当和与指定的sum相等时，说明找到所求的两个数，添加到list并返回list
			if(total==sum){
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }else if(total>sum){//当和比sum大时，把right指针调小，即左移
                right--;
            }else if(total<sum){//当和比sum小时，把left指针调大，即右移
                left++;
            }
        }
        
		//最后返回list
        return list;
    }
}



//返回值类型为int[]的代码：2ms，击败98%的用户
//注：结果数组：即用即new；判空和找不到写到一起。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int sum = nums[left] + nums[right];
            if(sum == target)
                return new int[]{nums[left], nums[right]};
            else if(sum < target)
                left++;
            else 
                right--;                
        }
        return new int[]{};
    }
}
