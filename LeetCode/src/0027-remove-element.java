//0027-移除元素
//思路：双指针（参考0026题）



//双指针：0ms，击败100%的用户
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;
        /*
        - i是存放新数组的，i的每个值都保证不为val
        - 是与数组之外的值进行比较，因此i和j都从0开始遍历
        - if语句与26题的区别：先赋值给nums[i]，后i++，因为val是数组以为的值，不能保证已有的索引值符合
        - 返回值是i，因为 i 始终指向的是预备存储的位置，即比实际新数组的末尾更前一位
        */
        
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

//当要删除元素很少时的双指针：0ms，击败100%的用户
/*
    算法：
    - 注：这里的双指针不是快慢指针，是首尾指针，一前一后逼近
    - 若val只占1或2个，且在首、尾等位置时，为了避免不必要的操作，对原来双指针方法进行改进
    - 当遇到 nums[i] = valnums[i]=val 时，可以将当前元素与最后一个元素进行交换，并释放最后一个元素。
      - 这实际上使数组的大小减少了 1。
    - 请注意，被交换的最后一个元素可能是想要移除的值。但是不要担心，在下一次迭代中，仍然会检查这个元素
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while(i<j){
            if(nums[i]==val){
                nums[i] = nums[j-1];
                j--;
            }
            else{
                i++;
            }
        }
        return i;
    }
}