//0189-旋转数组
//思路：暴力法；额外数组；环状替换；反转。



//暴力法：266ms，击败5%的用户
//算法：定义两个变量；两层循环：外层控制k，把末尾元素存起来，内层控制遍历数组，内层循环中进行交换。
class Solution {
    public void rotate(int[] nums, int k) {
        //定义外层循环和内层循环的临时存储变量
        int pre, tmp;

        //循环：外层控制移动位置数k，内层控制遍历整个数组
        for(int i = 0; i < k; i++){
            //将数组末尾的元素存在pre中，并在遍历过程中交换pre与nums[i]
            pre = nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++){
                tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }
}



//额外数组：1ms，击败78.4%的用户
//算法：定义辅助数组；一次遍历：以正确位置顺序将数据存入辅助数组；二次遍历：将辅助数组的数据按照位置移动到原数组。
class Solution {
    public void rotate(int[] nums, int k) {
        
        
        //定义辅助数组arr
        int [] arr = new int[nums.length];

        //第一次遍历：将数组元素移动到正确的位置
        for(int i=0; i<nums.length; i++){
            arr[(i+k) % nums.length] = nums[i];
        }

        //第二次遍历：将辅助数组的元素按位置搬运到原数组
        for(int j=0; j<nums.length; j++){
            nums[j] = arr[j];
        }
    }
}



//环状替换：0ms，击败100%的用户
/*
   - 分析: 
      - 直接把每一个数字放到它最后的位置，把被替换的数字保存在变量 temp 里面。
      - 然后，将被替换数字（temp）放到它正确的位置，并继续这个过程 n 次， n 是数组的长度。因为需要将数组里所有的元素都移动。
      - 特殊情况：如果 n%k==0，其中 k=k%n （因为如果 k 大于 n ，移动 k 次实际上相当于移动 k%n 次）。
      - 这种情况下，会在没有遍历所有数字的情况下回到出发数字。此时，从下一个数字开始再重复相同的过程。
    - 算法：
      - 对移动距离k进行处理（针对k>n的情况），并初始化计数器count；
      - 两层循环：外层为保证当n%k==0时，从下一个数字开始重复，实际是每个位置只走一次，时间复杂度仍然是n
      - 外层控制：环状的开始，从首位开始循环，start++，因为一共要移动n次，循环条件是计数器不再满足count<nums.length时结束；
      - 外层每次定义并维护两个指针：发射点cur和接收点next，并将start位置的元素存入临时变量pre，pre相当于弹道；
      - 内层循环：初始化next，交换pre与next位置的元素，并更新旧的接收点next为新的发射点cur，并且此时子弹已经进入弹道pre了，同时count++
      - 内层循环的循环条件：start!=cur，即当发射点又回到本次环状的起始位置start时，说明这一轮已经到头了，此时结束循环。
    - 注：本方法太烧脑了，毕竟代码是写给人类看的...
*/
class Solution {
    public void rotate(int[] nums, int k) {
        //对移动距离k进行处理（针对k>n的情况），并初始化计数器count
        k = k % nums.length;
        int count = 0;

        //两层循环：外层控制环状开始位置，内层控制一次环状循环中指针的更新
        for(int start = 0; count < nums.length; start++){
            //定义两个指针：发射点cur和接收点next，并将start的元素存入弹道pre
            int cur = start;
            int pre = nums[start];

            //内层循环：交换pre与next位置的元素，并更新旧的接收点next为新的发射点cur，并且此时子弹已经进入弹道pre了，同时count++
            do{
                int next = (cur + k) % nums.length; 
                
                //交换nums[next]与pre的值
                int tmp = nums[next]; 
                nums[next] = pre;
                pre = tmp;

                //更新发射点cur为上一个接收点，并更新count
                cur = next;
                count++;


            }while(start != cur);
        }
    }
}



//反转：0ms，击败100%的用户
//   - 算法：定义反转函数reverse；本体函数中，先对k进行取余处理；然后反转整个数组；然后反转前k个；最后反转剩余数组。
//   - 反转数组：双指针，一头一尾，交换头尾，然后更新两个指针使其向中间靠。当left指针不再小于right指针时，停止循环。
class Solution {
    public void rotate(int[] nums, int k) {
        //对k进行取余处理
        k = k % nums.length;
        
        //三次反转
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] arr, int left, int right){
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
