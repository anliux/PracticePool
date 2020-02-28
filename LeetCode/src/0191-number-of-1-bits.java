//0191-位1的个数
//思路：循环与位移动；位操作小技巧



//循环与位移动：1ms，击败99.8%的用户
//- 算法：定义计数器count和辅助变量flag；循环32次：n&flag的结果不为0时，计数器+1，然后flag左移一位；最后返回count。
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //定义计数器count和含1的辅助变量flag
        int count = 0;
        int flag = 1;

        //循环：遍历32位
        for(int i=0; i<32; i++){
            //当结果非0时，证明n的32位二进制中，与flag的1所在位对应的位置是1
            //注：这里判断是否是非0，不是等于1
            if((n & flag) != 0) //注：优先级!=高于&，要加小括号区分
                count++;
            
            //更新flag：将flag中的1向左移动
            flag = flag << 1;
        }

        //返回计数器结果count
        return count;
    }
}



//位运算小技巧：1ms，击败99.8%的用户
//- 算法：定义计数器；循环直到n为0：不为0则计数器+1，然后n和n-1做与运算消去最低位的1；返回计数器。
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //定义计数器
        int count = 0;

        //循环：直到n变成0，即此时n中原有的所有1都变成了0
        while(n != 0){
            count++;
            n = n & (n-1);
        }

        //返回计数器
        return count;
    }
}
