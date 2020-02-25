//0169-多数元素
//思路：暴力法；哈希表法；



//暴力法：2804ms，击败5%的用户
/*
    - 暴力算法遍历整个数组，然后用另一重循环统计每个数字出现的次数。将出现次数比其他数字加起来出现次数还多的元素返回。
    - 算法：初始化n/2；双层循环：外层控制比较基准，内层统计与基准相同的个数，并在内层结束后与n/2比较；最后return任一int型，比如-1.
*/
class Solution {
    public int majorityElement(int[] nums) {
        //定义变量保存n/2
        int l = nums.length / 2;

        //双层循环
        for(int i = 0; i < nums.length; i++){
            //充值计数器count
            int count = 0;

            //内层循环：与外层循环对应的基准比较，并计数
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == nums[i])
                    count += 1;
            }

            //每次内层循环结束后判断count是否大于n/2
            if(count > l)
                return nums[i];
        }

        //为了程序逻辑的完整性，返回任一int型，比如-1
        return 0;
    }
}



//哈希表法：
/*
算法：
  - 新建哈希表；
  - 新建max值和次数的变量；
  - 遍历数组：第一次出现时count赋值为1，否则在哈希表中对应count基础上+1，每次判断count范围并更新max两个变量；
  - 返回max值。
*/
class Solution {
    public int majorityElement(int[] nums) {
        //新建哈希表，并新建max的值和count变量。
        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        int maxCount = 0;

        //遍历数组
        for(int i = 0; i < nums.length; i++){
            //定义nums[i]对应的计数器，存入哈希表，并更新nums[i]对应的count最新值
            //`getOrDefault(Object key, V defaultValue)` : 如果存在key返回对应的value，否则返回defaultValue。
            //即查找map中是否有nums[i]，如果有，返回已有值并+1；否则，赋值为0，并+1.
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);

            //比较计数器，当本次count更大时，更新max和maxcount
            if(count>maxCount){
                max = nums[i];
                maxCount = count;
            }

            //比较maxcount与n/2。
            //注：经测试，加这段与否对复杂度影响几乎为零。
            //if(maxCount > nums.length)
            //    return nums[i];
        }

        //遍历结束后，返回最终的最大值
        return max;
    }
}
