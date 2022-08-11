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



//
