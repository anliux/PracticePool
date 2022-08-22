//56.2 - 数组中数字出现的次数II
//思路：位运算+遍历统计；哈希表法



//位运算+遍历统计：3 ms/85.08%; 43.1 MB/9.77%
class Solution {
    public int singleNumber(int[] nums) {
        //位运算：

        //初始化数组：int 4个8位，长度设为32
        int[] count = new int[32];

        //遍历：外循环遍历数组的每个元素，内循环统计每一位的和
            //内循环：每个元素的每一位的和：看成一个整体保存在count[]数组中
        for(int num : nums){
            for(int index = 0; index < 32; index++){
                count[index] += (num & 1);
                num = num >>> 1; 
            }
        }

        //初始化结果变量和参数3
        int res = 0, flag = 3;

        //遍历统计数组counts，并用或运算将遍历取余结果添加到res变量
        for(int i = 0; i < 32; i++){
            res <<= 1;
            if(count[31-i] % flag == 1)
            //这里因为res左移，因此先计算高位，从高到低 `counts[31-i] % m`
                res = (res | 1);
        }

        //返回结果res
        return res;
    }
}



//哈希表法：13 ms/35.78%; 42.4 MB/74.39%
class Solution {
    public int singleNumber(int[] nums) {
        //哈希表法
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], 1 + map.get(nums[i]));
            else
                map.put(nums[i], 1);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1)
                return nums[i];
        }
        return -1;
    }
}
