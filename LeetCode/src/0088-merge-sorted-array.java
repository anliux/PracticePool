//0088-合并两个有序数组
//思路：暴力法；双指针从前遍历；双指针从后遍历



//暴力法：1ms，击败31.9%的用户
//先复制数组到1，后对数组1进行排序
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}



//双指针从前往后：0ms，击败100%的用户
//先把数组1存起来，然后选值存入数组1，最后如果仍有剩余，直接存入
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //定义copy-1数组，以及三个数组的指针pi
        int [] copy1 = new int[m];
        System.arraycopy(nums1, 0, copy1, 0, m);

        int p1 = 0;//数组1的指针（copy1）
        int p2 = 0;//数组2的指针（num2）
        int p = 0;//最终数组的指针（num1）

        //从左向右遍历，比较结果后将较小的存入数组num1，注意临界值
        while(p1<m && p2<n){
            nums1[p++] = (copy1[p1]<nums2[p2]) ? (copy1[p1++]) : (nums2[p2++]);
        }

        //比较结束后，若仍有剩余，直接存到num1后面
        if(p1 < m)
            System.arraycopy(copy1, p1, nums1, p1+p2, m+n-p1-p2);
        if(p2 < n)
            System.arraycopy(nums2, p2, nums1, p1+p2, m+n-p1-p2);

    }
}



//双指针从后往前：0ms，击败100%的用户
//从后往前遍历不再需要额外空间来存储原有的nums1数组，节约了空间；特别注意各种临界值，尽量用最少的变量实现某个临界
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //定义三个数组的指针pi
        int p1 = m - 1;//数组1的指针（num1）
        int p2 = n - 1;//数组2的指针（num2）
        int p = m + n - 1;//最终数组的指针（最终的num1）

        //从右向左遍历，比较结果后将较大的存入数组num1
        while(p1>=0 && p2>=0){
            nums1[p--] = (nums1[p1]>nums2[p2]) ? (nums1[p1--]) : (nums2[p2--]);
        }

        //比较结束后，若仍有剩余，直接存到num1的前面
        //可以用m+n和p，用p2更直接：p2是没有存到nums1数组的临界值的索引，长度要再+1
        System.arraycopy(nums2, 0, nums1, 0, p2+1);

    }
}
