//0001-两数之和
//两种思路：暴力法；哈希表



//思路一：暴力法
class Solution {
    public int[] twoSum(int[] nums, int target) {
		//利用两层循环依次遍历，寻找相加为target的两个数组索引值
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
				//找到时：返回新建的匿名数组并将所得数组索引值存入该数组中
                if(nums[j] == target - nums[i]){
                    return new int []{i,j};
                }
            }
        }
		//遍历所有仍然找不到时：抛出非法参数异常
        throw new IllegalArgumentException("No two sum solution.");
    }
}



//思路二：两遍哈希表
class Solution {
    public int[] twoSum(int[] nums, int target) {
       //新建哈希表
       Map<Integer, Integer> map = new HashMap<>();

       //第一遍哈希表：先将数组数据存入哈希表
       for(int i=0; i<nums.length; i++){
           map.put(nums[i], i);
       } 

       //第二遍哈希表：
       for(int i=0; i<nums.length; i++){
           int complement = target - nums[i];
           if(map.containsKey(complement) && map.get(complement) != i){
               return new int[]{i, map.get(complement)};
           }
       }

       //遍历所有后找不到时，抛出异常
       throw new IllegalArgumentException("No two sum solution");
    }
}
/*
注：
因为判断存在的`map.containsKey(key)`找的是key，为了方便求和等式计算，
把key值设置为数组的值，同时因此把value值设置为数组索引（这就跟常规思路有点反了）。

基于以上，在判断不能是nums[i]本身时，就要用`map.get(complement) != i`

如果是正常的键值对应，`map.containsKey(key)`中，判断是否包含某个键key是没有意义的。
因此虽然上面的思路有点别扭，但是改过来的思路不能通过。
*/



//思路三：一遍哈希表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //新建哈希表
        Map<Integer, Integer> map = new HashMap<>();

		//遍历的同时寻找map中已存在的键值对是否有符合条件的
		//减掉一次循环，虽然不是叠加的循环，节约了时间
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];

			//判断哈希表中是否已经存在符合条件的键值对，符合时可直接return
			//这里没有判断是否重复，因为比较的是哈希表中的元素，
			//    而i对应的数组值本身还没有存入哈希表中，因此不必再判断
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

			//在if判断不符合没有return的情况下，继续讲数组存入哈希表
            map.put(nums[i],i);
        } 

		//遍历所有后找不到时，抛出异常
        throw new IllegalArgumentException("No two sum solution.");
    }
}
