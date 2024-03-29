//39-数组中出现次数超过一半的数字
//思路：暴力法；哈希表法；排序；摩尔投票法。



//暴力法：1732 ms/6.69%; 44.6 MB/83.95%
/*
    - 暴力算法遍历整个数组，然后用另一重循环统计每个数字出现的次数。将出现次数比其他数字加起来出现次数还多的元素返回。
    - 算法：初始化n/2；双层循环：外层控制比较基准，内层统计与基准相同的个数，并随时与n/2比较；最后return任一int型，比如-1.
*/
class Solution {
    public int majorityElement(int[] nums) {
        //定义变量保存n/2
        int l = nums.length / 2;

        //双层循环
        for(int i = 0; i < nums.length; i++){
            //每次重置计数器count
            int count = 0;

            //内层循环：与外层循环对应的基准比较，并计数
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == nums[i])
                    count += 1;
                //随时判断count是否大于n/2
                if(count > l)
                    return nums[i];
            }
        }

        //为了程序逻辑的完整性，返回任一int型，比如-1
        return 0;
    }
}



//哈希表法：17 ms/6.69%; 46.7 MB/8.80%
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

//简化的哈希表法：
//不用定义count和max，计数时，直接赋值1和获取key对应的值即可；中间枝剪，符合时直接返回；最后返回0。
class Solution {
    public int majorityElement(int[] nums) {
        //哈希表法
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                map.put(nums[i], map.get(nums[i])+1);
            if(map.get(nums[i]) > (nums.length/2))
                return nums[i];
        }
        return 0;
    }
}



//排序：2ms/56.24%; 44.6 MB/87.69%
//- 算法：对数组排序；返回排序后的n/2索引对应的元素
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}



//摩尔投票法：1 ms/99.93%; 44.9 MB/55.63%
/*
  - 算法：
      - 定义比较基准flag=nums[0]和计数器count=1；
      - 遍历数组：与基准相同+1，不同-1，且变为0时，更新基准为下一个索引对应的元素；
      - 返回最后计数器不为0的基准。
*/
class Solution {
    public int majorityElement(int[] nums) {
        //新建基准flag和计数器count（初始化这两个变量为数组第一个元素对应的值）
        int flag = nums[0];
        int count = 1;

        //遍历数组：从数组第二个元素，即索引值1开始，遍历整个数组
        for(int i=1; i<nums.length; i++){
            //如果以上遍历后计数器为0，则从当前遍历到的i开始为基准重新统计
            if(count == 0){
                count = 1;
                flag = nums[i];
            }
            //否则，与基准flag比较，并更新count：相同+1，不同-1
            else{
                count = (nums[i]==flag) ? (count+1) : (count-1);
            }
        }

        //结束后返回基准: 可加一条判断没找到结果的情况
        if(count == 0) 
            return -1;
        
        return flag;
    }
}
