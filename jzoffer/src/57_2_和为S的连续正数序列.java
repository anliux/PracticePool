//57.2 - 和为 S 的连续正数序列
//思路：滑动窗口

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