//946. 验证栈序列
//思路：模拟



//模拟：3 ms/63.69%; 41.4 MB/12.12%
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //初始化辅助栈和索引值
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        //遍历压栈序列
        for(int num:pushed){
            //每次循环都会进行的入栈操作
            stack.push(num);

            //判断：只有当栈顶匹配时，才移动弹栈序列索引值查找下一个元素
            //注意：peek()的异常EmptyStackException - 如果堆栈为空，先判空
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }

        //返回结果
        return stack.isEmpty();
    }
}
