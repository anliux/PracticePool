//0016-最接近的三数之和
//思路：双指针



//双指针法：6ms，击败87%的用户
/*
 - 算法：边界值；排序；两层循环遍历；返回结果。没要求，因此不用去重。
    - 边界值：假设必存在答案的话，此步可省略（否则也不知道该return什么）；
    - 数组排序：调用`Arrays.sort(nums)`; 用nlogn的时间复杂度；
    - 定义结果res，并初始化为数组中的前三个元素之和，否则容易出现定义过大或过小的问题；
    - 两层循环：外层控制基准，内层控制双指针遍历数组
      - 定义左右指针
      - 内循环：求基准+左右指针对应元素的和；更新res；根据sum与target比较情况移动指针；
    - 返回结果res。
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //依照上一题的思路: 边界值；排序；两层循环遍历。没要求，因此不用去重。
        //边界值：假设必存在答案的话，此步可省略
        
        //排序
        Arrays.sort(nums);

        //定义结果变量: 初始化为数组中的前三个元素之和，否则容易出现定义过大或过小的问题
        int res = nums[0] + nums[1] + nums[2];


        //两层循环：外层控制基准，内层控制双指针遍历数组
        for(int i = 0; i < nums.length; i++){
            //定义左右指针
            int left = i + 1;
            int right = nums.length - 1;
       
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                //取差值最小的sum最为res
                if(Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
                
                //对sum的值进行判断
                if(sum == target)
                    return target;
                else if(sum < target)
                    left++;
                else if(sum > target)
                    right--;                
            }
        }

        //返回结果
        return res;
    }
}
