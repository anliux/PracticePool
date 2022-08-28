//0239-滑动窗口最大值
//思路：暴力法；双向队列；动态规划



//暴力法：33ms，击败25.66%的用户；2022年暴力法超时了
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //暴力法：判空；定义结果数组；两层循环；返回结果
        //判空
        if(nums==null || k<=0)
            return new int[0];

        //定义结果数组
        int[] res = new int[nums.length-k+1];
        
        //两层循环：外层控制起始，内层控制遍历窗口
        for(int i = 0; i < nums.length-k+1; i++){
            int max = nums[i];//或者：int max = Integer.MIN_VALUE;
            for(int j = i; j < i+k; j++){
                if(nums[j] > max)
                    max = nums[j];
            }
            res[i] = max;//将本窗口的最大值存入结果数组
        }
        
        //返回结果
        return res;
    }
}



//双向队列：28 ms/26.56%; 60.2 MB/4.98%
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //双端队列：

        //判空：
        if(nums==null || k<=0)
            return new int[0];

        //初始化：双端队列deque，结果数组res
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];

        //构建窗口
        for(int i = 0; i < k; i++){
            //循环更新max：
            while(!deque.isEmpty() && deque.peekLast()<nums[i])
                deque.removeLast();
            
            //添加其他元素到队尾
            deque.addLast(nums[i]);
        }

        //结果数组第一个元素赋值
        res[0] = deque.peekFirst();

        //窗口滑动：
        for(int i = k; i < nums.length; i++){
            //删去新添加的元素：当删去元素是max时，删去队首元素
            if(deque.peekFirst()==nums[i-k])
                deque.removeFirst();
            
            //循环更新max：
            while(!deque.isEmpty() && deque.peekLast()<nums[i]){
                deque.removeLast();
            }

            //添加其他元素到队尾
            deque.addLast(nums[i]);

            //添加本轮max到结果数组
            res[i-k+1] = deque.peekFirst();
        }

        //返回结果数组
        return res;
    }
}
