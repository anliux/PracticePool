//0015-三数之和
//思路：双指针



//耗时：29ms，击败91.15%的用户
/*
  - 算法：
    - 定义二维List；
    - 边界值判断：判空和判断数组长度小于3；
    - 排序得到有序数组；
    - 循环：外循环控制基准，内循环控制某个基准的双指针遍历数组
      - 边界值判断：基准大于0；基准去重；
      - 定义左右指针；
      - 内循环：求sum；根据sum的正负情况分别移动指针 -- 注意sum为0时指针去重；
    - 返回结果。
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //根据返回值类型定义结果变量
        List<List<Integer>> ans = new ArrayList<>();

        //边界值判断：数组为空，或者数组长度小于3时
        if(nums == null || nums.length < 3)
            return ans;
        
        //排序得到有序数组
        Arrays.sort(nums);

        //循环：外循环控制基准，内循环控制某个基准的双指针遍历数组
        for(int i = 0; i < nums.length; i++){
            //边界值判断：基准为正；基准去重
            if(nums[i] > 0)
                break;
            if(i > 0 && (nums[i-1] == nums[i]))
                continue;
            
            //定义左右指针
            int left = i + 1;
            int right = nums.length - 1;

            //内循环：左右指针遍历数组
            while(left < right){ //相遇或交错时结束本次循环
                //定义和
                int sum = nums[i] + nums[left] + nums[right];

                //对sum的正负情况进行讨论
                if(sum > 0)
                    right--;
                else if(sum < 0)
                    left++;
                else if(sum == 0){
                    //将结果添加到ans，并进行左右指针的去重判断
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left] == nums[left+1]) 
                        left++;
                    while(left<right && nums[right] == nums[right-1]) 
                        right--;

                    //移动指针查找其他可能的组合
                    left++;
                    right--;
                }
            }
        }

        //返回结果
        return ans;
    }
}
