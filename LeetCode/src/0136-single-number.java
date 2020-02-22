//0136-只出现一次的数字
//思路：暴力法(略)；排序(略)；哈希表；异或



//哈希表：12ms，击败21.6%的用户
//算法：新建哈希表；第一次遍历：判断并存入map；第二次遍历：判断nums[i]对应value是否为1，为1时返回；最后为了程序逻辑完整，返回任意int型树
class Solution {
    public int singleNumber(int[] nums) {
        //新建哈希表
        Map<Integer, Integer> map = new HashMap<>();

        //第一次循环：遍历nums数组，验证，更新count值，并将最终结果存入map
        for(int i=0; i<nums.length; i++){
            //判断nums[i]作为key对应的value是否为null，为空时赋值count=1；
            //  否则对应value++，并将nums[i]和value对应值put到map中
            //注：必须要判断get()是否为空，否则可能空指针异常
            int count;

            if( map.get(nums[i]) == null )
                count = 1;
            else 
                count = 1 + map.get(nums[i]);
            
            //存入map
            map.put(nums[i], count);
        }

        //第二次循环：遍历nums数组，查看nums[i]对应的count是否为1
        for(int i : nums){ // foreach语句：i = nums[i]
            if(map.get(i) == 1){
                return i;
            }
        }

        //这里不写return会报错，虽然上一步会找到并返回，但是不写return时，程序有逻辑错误
        //PS：因为所给的用例一定在上一步返回了，所有这里返回任意int型整数即可。
        return 10000;
    }
}



//异或：1ms，击败99.6%的用户
//根据异或特点：相同数异或结果为0；任何数与0异或结果仍为原数
//算法：定义一个变量a，并初始化为nums[0]；从nums[1]开始遍历，在循环体中不断异或`a=a^nums[i]`；返回遍历结束后返回a
class Solution {
    public int singleNumber(int[] nums) {
        //定义变量a，并初始化
        int a = nums[0];

        //遍历数组
        for(int i=1; i<nums.length; i++){
            a = a ^ nums[i];
        }

        //返回最终结果a
        return a;
    }
}
