//57.2 - 和为 S 的连续正数序列
//思路：滑动窗口



//滑动窗口，返回值int[][] 朴素解法：2 ms/95.15%; 39.5 MB/55.10%
class Solution {
    public int[][] findContinuousSequence(int target) {
        //滑动窗口：朴素解法

        //初始化：
        ArrayList<int[]> list = new ArrayList<>();
        int left = 1, right = 2; 
        int sum = 3;

        //双指针遍历：
        //整个循环中，每次移动指针时都需要更新s的值；
        //如果是每次循环之前按照等差数列求和公式计算sum，则不用。
        while(left<right){//至少含有两个数: 两指针没有边界限制
            if(sum == target){
                //符合时，循环存入
                int[] temp = new int[right-left+1];
                for(int i = 0; i < temp.length; i++){
                    temp[i] = left+i;
                }
                list.add(temp);
                sum -= left;//记得更新sum
                left++;
            }else if(sum < target){
                right++;
                sum += right;//记得更新sum
            }else{
                sum -= left;//记得更新sum
                left++;
            }
        }

        //返回结果：转换并返回；也可以直接toArray(T[] a)返回
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;

    }
}



//滑动窗口+等差数列求和+其他返回值类型：
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        
	//新建一个存储ArrayLis的ArrayList
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();

	//初始化滑动窗口的大小指针
        int small = 1;
        int big = 2;

	//进行循环：判停条件是小指针追上大指针
        while(big>small){
		//等差数列求和公式计算滑动窗口中序列的和。
		//注意：虽然没有进行优化（在和的基础上进行加减），但是思路更清晰
            	int cur = (small+big)*(big-small+1)/2;
            
		//当和与所求sum相等时，把序列存入list列表，并big++
		if(cur==sum){
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=small; i<=big; i++){
			    list.add(i);
		}
		result.add(list);
		big++;
		    }else if(cur<sum){//否则，当和小于sum时，增大big指针，以增加序列中的数，以此增大cur
			big++;
		    }else{//否则，当和大于sum时，增大small指针以减少序列中的数，以此减小cur
			small++;
		    }
        }
	//返回结果
        return result;
        
    }
}



//返回值类型为int[][]的情况：5ms，击败44%的用户
class Solution {
    public int[][] findContinuousSequence(int target) {
        //滑动窗口；等差数列求和公式；先存入List，最后转为数组

        //首先，新建ArrayList存储结果
        ArrayList<int[]> res = new ArrayList<>();
        
        
        //初始化窗口指针
        int left = 1;
        int right = 2;

        //循环：直到左指针追上右指针
        while(left < right){
            //用等差数列求和公式计算左右指针中间元素的和
            int sum = (left + right) * (right - left + 1) / 2;

            //根据sum与target的比较移动指针
            if(sum == target){
                //将元素添加到int[]数组，然后将该数组添加到List，并移动左指针继续寻找下一组
                int [] arr = new int[right - left + 1];
                for(int i = left; i <= right; i++){
                    arr[i - left] = i;
                }
                res.add(arr);
                left++;
            }
            else if(sum < target){
                //偏小时：增大右指针来包含更多数
                right++;
            }
            else if(sum > target){
                //偏大时：增大左指针来缩小窗口
                left++;
            }
        }

        //转为数组，并返回
        return res.toArray(new int[res.size()][]);
    }
}
