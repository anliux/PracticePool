//0239-滑动窗口最大值
//思路：暴力法；双向队列；动态规划



//暴力法：33ms，击败25.66%的用户
/*
    - 算法：
      - 定义数组元素个数n
      - 判空：`n*k==0`，意味着n和k中存在0，此时，新建长度为0的数组并返回
        - 注：测试用例`输入：[] 0; 输出：[]`，因此判空不能返回null，需要返回新建长度为0的数组
      - 定义结果数组output，数组长度为滑动窗口个数 `n-k+1`
      - 两层循环：外层控制起始，内层控制小窗口内的遍历
        - 定义最大值max，遍历本窗口内的所有数字并更新max，然后将max作为output[i]存入结果数组
      - 返回结果数组
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //暴力法：定义数组长度变量；判空；定义结果数组；两层循环；返回结果

        //定义数组长度变量n
        int n = nums.length;

        //判空
        if(n * k == 0)
            return new int[0];

        //定义结果数组output
        int [] output = new int[n - k + 1];

        //两层循环：外层控制起始，内层控制遍历窗口
        for(int i = 0; i < (n-k+1); i++){
            //定义最大值max
            int max = Integer.MIN_VALUE;

            //遍历窗口
            for(int j = i; j < i+k; j++){
                if(nums[j] > max)
                    max = nums[j];
            }

            //将本窗口的最大值存入结果数组
            output[i] = max;
        }

        //返回结果数组
        return output;
    }
}



//
