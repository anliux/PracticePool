//66 - 构建乘积数组
//维护两个三角的数组；改进：节省一个数组的空间



//维护两个三角的数组: 1ms/100%; 53.3 MB/19.93%
class Solution {
    public int[] constructArr(int[] a) {
        //判空
        if(a==null || a.length==0)
            return a;
        
        //构建左右两个三角的数组，并初始化
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len-1] = 1;

        //左侧数组：递增，从上到下构建，规律是left(n)=left(n-1)*a(n-1);
        for(int i = 1; i < len; i++){
            left[i] = left[i-1] * a[i-1];
        }

        //右侧数组：递减，从下到上构建，规律是right(n)=right(n+1)*a(n+1);
        for(int j = len-2; j>=0; j--){
            right[j] = right[j+1] * a[j+1];
        }

        //构建结果数组：左右两个三角数组的同一行乘积
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = left[i] * right[i];
        }

        //返回结果数组
        return ans;
    }
}



//改进：节省一个数组的空间：1ms/100%; 53.6 MB/5.09%
class Solution {
    public int[] constructArr(int[] a) {
        if(a==null || a.length==0)
            return a;
        int len = a.length;

        int[] ans = new int[len];
        ans[0] = 1;
        int tmp = 1;
        
        //计算左侧的上三角
        for(int i = 1; i < len; i++){
            ans[i] = ans[i-1] * a[i-1];
        }

        //将右侧的下三角直接累乘到结果数组
        for(int i = len-2; i>=0; i--){
            tmp *= a[i+1];
            ans[i] *= tmp;
        }

        //返回结果数组
        return ans;
    }
}
