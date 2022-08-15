//45. 把数组排成最小的数



//自定义排序-模拟快排：4 ms/97.27%; 41.3 MB/28.37%
//参考40. 最小的k个数
class Solution {
    public String minNumber(int[] nums) {
        //初始化字符串列表
        String[] strs = new String[nums.length];

        //遍历并保存各个数字的字符串格式
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        //排序
        quickSort(strs,0,strs.length-1);

        //初始化可变字符串StringBuilder，拼接结果字符串数组并返回结果
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public void quickSort(String[] strs, int left, int right){
        //递归出口：
        if(left >= right)
            return;
        
        //初始化哨兵指针
        int i = left, j = right;

        //遍历直到哨兵指针相遇：基准left
        while(i<j){
            while((strs[j]+strs[left]).compareTo(strs[left]+strs[j]) >=0 && i<j)//从右向左找第一个小于基准值的: j+left>=left+j,则j大于等于left
                j--;
            while((strs[i]+strs[left]).compareTo(strs[left]+strs[i])<=0 && i<j)//从左向右找第一个大于基准值的: i+left<=left+i, 则i小于等于left
                i++;
            swap(strs,i,j);
        }

        //交换基准，并递归
        swap(strs,i,left);
        quickSort(strs, left, i-1);
        quickSort(strs, i+1, right);
    }

    public void swap(String[] strs, int a, int b){
        String temp = strs[a];
        strs[a] = strs[b];
        strs[b] = temp;
    }
}



//其他方法：lambda表达式（略）
