//40. 最小的k个数


//库函数排序：6 ms/73.93%; 43.1 MB/5.08%
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //库函数
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}

//库函数排序-只用一个库函数：7 ms/69.67%; 42.1 MB/70.67%
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //库函数
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }
}



//快速排序的数组划分：2 ms/92.29%; 42.1 MB/70.81%
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //快速排序的数组划分
        if(k>=arr.length)
            return arr;
        return quickSort(arr, k, 0, arr.length-1);
    }

    private int[] quickSort(int[] arr, int k, int left, int right){
        //初始化哨兵i，j, 并进行快排的步骤
        int i = left, j = right;
        while(i<j){//两哨兵相遇时跳出循环
            while(i<j && (arr[j] >= arr[left])) j--;//从右向左找第一个小于基准数的值
            while(i<j && (arr[i] <= arr[left])) i++;//从左向右找第一个大于基准数的值
            swap(arr, i, j);//交换这两个数
        }
        //一轮遍历结束后，将基准值[left]与哨兵相遇初元素交换
        swap(arr, left, i);

        //划分完毕后，基准数为arr[i] ，左/右子数组区间分别为[left,i−1], [i+1,right]
        if(k>i) return quickSort(arr, k, i+1, right);
        else if(k<i) return quickSort(arr, k, left, i-1);
        else return Arrays.copyOf(arr,k);
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
