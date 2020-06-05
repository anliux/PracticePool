//61 - 扑克牌中的顺子
//思路：排序 + 遍历判重 + 求差



/*
排序 + 遍历
先对数组执行排序。
判别重复： 排序数组中的相同元素位置相邻，因此可通过遍历数组，判断 nums[i]=nums[i+1] 是否成立来判重。
获取最大 / 最小的牌： 排序后，数组末位元素 nums[4] 为最大牌；元素 nums[joker] 为最小牌，其中 joker 为大小王的数量。

注：对于求差<5的设定
- 设顺子为[1,2,3,4,5]，则max-min=4<5，即在不重复的情况下，差值小于5时，可以铺满5个空格，并且不重复即大小王的个数可以补充所有空缺。
- 举不出反例：特值法辅助理解。
*/


//1ms，击败85%的用户
class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++){
            if(nums[i]==0)
                joker++;
            else if(nums[i]==nums[i+1])
                return false;
        }
        return nums[4] - nums[joker] < 5;
    }
}
