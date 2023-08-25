//51.数组中的逆序对
//思路：归并排序



//归并排序：37ms/23.21%; 51.67MB/38.38%
class Solution {
    //初始化全局变量
    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        //全局变量赋值
        this.nums = nums;
        tmp = new int[nums.length];
        
        //调用mergeSort()函数，并返回结果
        return mergeSort(0,nums.length-1);
    }

    //定义归并排序函数
    private int mergeSort(int left, int right){//注意：心中有两组分开数组和一组合并数组
        //递归终止条件：当两端指针碰头时，拆分到了最小格子，即没有逆序对
        if(left >= right)
            return 0;

        //递归拆分环节：求中间值，分开为两组递归，并累加为res
        int mid = (left+right)/2;
        int res = mergeSort(left, mid) + mergeSort(mid+1,right);

        //合并环节：分别从两组的左起元素向后遍历，对比并计数
            //注意：res只有一种情况时，才计数
        //初始化两个指针：分别从两组数组的最左侧开始，向后遍历
        int i = left, j = mid + 1;

        //辅助数组tmp赋值：遍历，将本组的两组数组的原有顺序(即已经对比排序过的)复制到tmp数组
        for(int k = left; k <= right; k++){
            tmp[k] =  nums[k];
        }

        //遍历本组从left到right范围内的两组数组：2指针对应元素大小的3种情况进行分类处理
            //k对应即将放入nums的元素位置，i,j两指针，每轮分别进行更新
            //游戏规则：每轮将i，j对应元素中较小的一个放入nums，并指针前移1位
            //先两种某一组已对比完的情况，后处理找到逆序对的情况；其中有两种处理相同，可合并
        for(int k = left; k <= right; k++){
            //i==mid+1, 即前一组已遍历到头：将后一组元素依次放入nums数组
            if(i==mid+1)
                nums[k] = tmp[j++];//将后一组指针j后移1的步骤放入本句中

            //j==right+1,即后一组已遍历到头：将前一组元素依次放入nums数组
            //当前<后，即非逆序时，将前一组元素放入nums，并i++，与j==right+1处理相同，故合并
            else if(j==right+1 || tmp[i] <= tmp[j])//=的情况：取小值时，优先将小数组的值放入nums；
                nums[k] = tmp[i++];

            //前>后：逆序对，将较小的后一组元素放入nums，并j++
            else{//即tmp[i] > tmp[j]的情况，统计逆序对数量
                nums[k] = tmp[j++];
                res += mid + 1 - i; //i到第二组首位mid+1之间的所有元素，含i，不含mid+1
            }
        }

        //返回结果res
        return res;
    }
}



//用每组从右往左指针遍历的方法不明原因报错：[4,5,6,7,8,9]，输出：-3？
/*
class Solution {
    //声明成员变量
    int[] tmp, nums;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length-1);
    }

    //定义归并排序函数
    private int mergeSort(int left, int right){
        //递归结束条件：递归至单个元素，逆序对为0
        if(left>=right)
            return 0;

        //分解：定义中值mid和逆序对计数res
        int mid = (left + right)/2;
        int res = mergeSort(left, mid) + mergeSort(mid+1, right);

        //合并：
        //定义两指针：用于分别指向两个数组
        int i = mid, j = right;

        //将两组数组已有顺序存入辅助数组tmp：遍历[left, right]
        for(int k = left; k <= right; k++){
            tmp[k] = nums[k];
        }

        //遍历：针对两个指针对应的元素大小，分3类情况处理
        for(int k = right; k >= left; k--){
            //前一组已遍历到头：后一组从大到小放入nums
            //前<后：较大的前一组放入nums，与 i==left-1 的处理一样
            if(i==left-1 || tmp[i] <= tmp[j]){
                nums[k] = tmp[j--];
            }

            //后一组已遍历到头：前一组从大到小放入nums
            else if(j==mid){
                nums[k] = tmp[i--];
            }

            //前>后：逆序，[mid+1,j]的元素均小于i对应元素；将较大的i放入nums
            else if(tmp[i]>tmp[j]){
                res = res+j-mid; //j-(mid+1)+1
                nums[k] = tmp[i--];
            }
        }

        //返回结果res
        return res;
    }
}
*/
