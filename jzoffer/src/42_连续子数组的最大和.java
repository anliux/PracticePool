//42-连续子数组的最大和
//思路：暴力法；动态规划；贪心；分治



//暴力法：超时了，最后一个很长的测试用例没有通过
/*
  算法：
  - 寻找所有的可能子序和，并求最大值
    - 复杂度：时间O(N^2)，空间O(1)
    - 首先定义并初始化max为数组第一个元素
    - 按照一定规律遍历数组，比如从i开始遍历到末尾，不断取和，比较并取max，然后i++
    - 两层循环：外循环控制开始的i值，内循环控制在i索引开始，形成的子序列
*/
class Solution {
    public int maxSubArray(int[] nums) {
        //定义max
        int max = nums[0];

        //外循环控制开始的i值，内循环控制在i索引开始，形成的子序列
        for(int i=0; i<nums.length; i++){
            //定义sum：每次外循环更新时，sum归0，重新开始统计
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum>max)
                    max = sum;
            }
        }

        //返回最终的max
        return max;
    }
}



//贪心：0ms/100%; 48.4 MB/7.10%
/*
  算法：
  - 从左向右遍历，一个个数累加；当sum<0，重新开始找子序列
    - 所求最大值max可由if判断语句比较得到，也可由Math.max(i,j)直接求得
    - sum初始化为0，小于0的sum说明累加后比初始值更小了
    - "重新找"指的是：sum归0， 并从下一个元素起，重新累加
  - 复杂度：时间O(n)，空间O(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        //定义最大值max和累加和sum，其中max为最终返回值，sum为临时存储的累加和
        int max = nums[0];
        int sum = 0;

        //循环遍历nums数组
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            //max可由if判断语句比较求得，也可由Math函数直接求得
            //max = Math.max(sum, max); 
            if(sum > max)
                max = sum;

            //判断sum的值：小于0时，sum归0， 并从下一个元素起，重新累加
            if(sum<0){
                sum = 0;
            }
        }

        //返回循环结束后最终的max
        return max;
    }
}



//动态规划：1 ms/41.19%; 47.9 MB/73.23%
/*
    算法：
    - 复杂度：时间O(n), 空间O(n)，可优化到O(1)
      - 只用到dp数组中的前一项，因此可以用int代替一维数组，对空间复杂度优化
    - dp[i]: nums中，以nums[i]结尾的最大子序和
    - dp[i]=max(dp[i-1]+nums[i], nums[i]);
*/
class Solution {
    public int maxSubArray(int[] nums) {
        //定义结果result和int数组dp，并初始化为nums数组的第一个元素
        int result = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        //循环遍历nums数组
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            result = Math.max(dp[i], result);
        }

        return result;
    }
}

//动态规划改进空间复杂度：0 ms/100.00%; 48.2 MB/24.54%
class Solution {
    public int maxSubArray(int[] nums) {
        //定义结果result和int数组dp，并初始化为nums数组的第一个元素
        int result = nums[0];
        int dp = nums[0];

        //循环遍历nums数组
        for(int i=1; i<nums.length; i++){
            dp = Math.max(dp + nums[i], nums[i]);
            result = Math.max(dp, result);
        }

        return result;
    }
}

//贴一个动态规划k神的优雅写法：用原数组存储dp结果
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}



//分治
/*
      算法：
      - 复杂度：时间O(nlogn)，空间O(logn)
      - 取数组的中心点为中心，那么最大子序列要么在中心左，要么在右，要么跨中心
      - 分三种情况进行考虑
      - 跨中心的情况，又可以分治中心点左侧和右侧的最大子序列问题
      - 注：对比以上思路，分治的思路过于复杂，不详细分析了。
*/
