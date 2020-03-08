//0239-滑动窗口最大值
//思路：暴力法；双向队列；动态规划



//暴力法：33ms，击败25.66%的用户
/*
    - 算法：
      - 定义数组元素个数n
      - 判空：`n*k==0`，意味着n和k中存在0，此时，新建长度为0的数组并返回
        - 注：测试用例`输入：[] 0; 输出：[]`，因此判空不能返回null，需要返回新建长度为0的数组
      - 定义结果数组output，数组长度为滑动窗口个数 `n-k+1`
      - 两层循环：外层控制，内层控制小窗口内的遍历
        - 定义最大值max，遍历本窗口内的所有数字并更新max，然后将max作为output[i]存入结果数组
      - 返回结果数组
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //暴力法：定义数组长度变量；判空；定义结果数组；两层循环；返回结果

        //定义数组长度变量n
        int n = nums.length;

        //判空
        if(n * k == 0)
            return new int[0];

        //定义结果数组output
        int [] output = new int[n - k + 1];

        //两层循环：外层控制起始，内层控制遍历窗口
        for(int i = 0; i < (n-k+1); i++){
            //定义最大值max
            int max = Integer.MIN_VALUE;

            //遍历窗口
            for(int j = i; j < i+k; j++){
                if(nums[j] > max)
                    max = nums[j];
            }

            //将本窗口的最大值存入结果数组
            output[i] = max;
        }

        //返回结果数组
        return output;
    }
}



//双向队列：13ms，击败69%的用户
/*
- 算法：
      - 定义数组元素个数n；
      - 判空：`n*k==0`；
      - 边界值：`k=1`时返回原数组；
      - 新建数组双端队列deq：`ArrayDeque<Integer> deq = new ArrayDeque<Integer>();`；
      - 定义窗口最大值对应的索引max_index；
      - 首先：遍历第一个窗口，清理队首队尾，将元素添加到队列last，并找出最大值；
      - 定义输出数组output，并将第一个元素初始化为max_index对应的元素；
      - 其次：以每个窗口的最右端为基准，从第二个窗口开始，遍历至数组末尾最后一个元素
        - 首先清理队首first：判断 -- 当队列不为空，且队首等于本窗口最左侧的左侧元素时，移除首位（i-k是已经滑出本窗口的最近索引）；
        - 其次清理队尾last：循环（可能存在多个不符的队尾元素） -- 当队列不为空，且当前元素大于队尾时，移除队尾元素；
          - 这里：如果i索引值大于已有队尾，会在这一步移除，因此，下一步直接添加到队尾即可，包含了两种情况
        - 将当前元素的索引添加到队列（作为在最大值滑出窗口后，可能成为最大值的元素，放入队尾）
        - 最后将队首索引值对应的数组元素赋值给第i个元素
      - 返回结果数组output
      - 注：
        - 存入队列的是索引值，不是数组元素值；
        - 赋值给结果数组output的是队首索引值对应的数组元素，不是直接将队首元素存入结果数组；
        - 清理队首队尾重复代码，可以封装到一个函数中，这里就全写在同一个函数中了；
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //步骤：初始化变量；边界值；新建数组双端队列；遍历第一个窗口；初始化输出数组；遍历剩余窗口；返回
        //注：数组双端队列用于存储可能的最大值，输出数组用于存储最终结果
        
        //定义数组元素个数n
        int n = nums.length;

        //判空与边界值判断
        if(n * k == 0)
            return new int[0];
        if(k == 1)
            return nums;
        
        //新建数组双端队列
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();

        //定义窗口最大值对应的索引max_index
        int max_index = 0;

        //遍历第一个窗口，清理队首队尾，将元素添加到队列last，并找出最大值保存
        for(int i = 0; i < k; i++){
            //清理队首：非空，且队首索引值为i-k时，移除队首元素
            if(!deq.isEmpty() && deq.getFirst() == i-k)
                deq.removeFirst();
            
            //清理队尾：如果当前i对应的元素比队尾索引值对应元素大，则移除队尾元素
            //这里如果i对应的元素大于当前队首，这一步会移除，因此下一步直接添加到队尾即可
            while(!deq.isEmpty() && nums[deq.getLast()] < nums[i])
                deq.removeLast();

            //添加索引值到队尾
            deq.addLast(i);

            if(nums[i] > nums[max_index])
                max_index = i;
        }

        //初始化结果数组output，并将第一个元素赋值为nums[max_index]
        int [] output = new int[n - k + 1];
        output[0] = nums[max_index];

        //遍历数组：以窗口的最右侧元素为基准，遍历剩余滑动窗口
        for(int i = k; i < n; i++){
            //清理队首：非空，且队首索引值为i-k时，移除队首元素
            if(!deq.isEmpty() && deq.getFirst() == i-k)
                deq.removeFirst();
            
            //清理队尾：如果当前i对应的元素比队尾索引值对应元素大，则移除队尾元素
            //这里如果i对应的元素大于当前队首，这一步会移除，因此下一步直接添加到队尾即可
            while(!deq.isEmpty() && nums[deq.getLast()] < nums[i])
                deq.removeLast();

            //添加索引值到队尾
            deq.addLast(i);

            //将本次窗口中的队首存入结果数组
            output[i-k+1] = nums[deq.getFirst()];
        }

        //返回结果数组
        return output;

    }
}
