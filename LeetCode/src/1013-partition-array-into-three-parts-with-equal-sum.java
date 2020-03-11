//1013-将数组分成和相等的三个部分
//思路：寻找切分点



//寻找切分点：0ms，击败100%的用户
/*
  - 算法：
    - 遍历数组并求和sum，然后计算sum是否可以被3整除，不能则false，否则继续以下步骤；
    - 将sum更新为sum整除3的结果作为sum累加的target；
    - 定义当前和curSum，以及计数器count；
    - 循环：到`i<length-1`是精髓
      - 累加到curSum；
      - 判断：当curSum等于sum时，计数器+1，并将curSum置0，紧接着判断计数器是否为2，为2即可返回true；
    - 否则，循环结束后还没有return时，证明找不到，返回false。
    - 注：因为题目规定了数组长度取值范围，因此没有判空。
  - 注意测试用例`[1,-1,1,-1]`，因此循环时需要保证最后一个数组非空，即循环时，到`i<length-1`。
*/
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        //数组求和，并判断和sum是否可以三等分
        int sum = 0;
        for(int num : A)
            sum += num;
        if(sum % 3 != 0)
            return false;
        
        //如果sum可以三等分，则更新sum为三等分的结果，作为比较的target
        sum /= 3;

        //定义当前和curSum，以及计数器count
        int curSum = 0, count = 0;

        //遍历数组
        for(int i = 0; i < A.length - 1; i++){
            curSum += A[i];

            //对当前和进行监测：为sum时即为三分之一段
            if(curSum == sum){
                //找到一段时：计数器+1，当前和清零
                count++;
                curSum = 0;

                //对计数器进行监测：为2时，证明可以找到三段，返回true
                if(count == 2)
                    return true;
            }
        }

        //若循环结束后仍没有返回，则说明找不到
        return false;
    }
}
