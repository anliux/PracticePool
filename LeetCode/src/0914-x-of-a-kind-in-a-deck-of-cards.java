//0914-卡牌分组
//思路：暴力法



//暴力法：7ms，击败51%的用户
/*
- 算法：
      - 第一步：计数。
      - 定义数组长度N：即卡牌总数；
      - 模拟哈希表统计每个数字的出现次数：定义长10000的数组count，然后遍历数组deck并将元素值作为count数组索引值并自增1；
      - 第二步：统计数字个数。
      - 定义数组列表values，遍历count数组，并将count数组中所有大于0的元素添加到values数组列表；或依然用普通数组存储即可；
      - 第三步：遍历并判断。
      - 两层循环：外循环控制从2开始枚举的X(包括等于N)，内循环控制两个指标的取余，不符合时继续增加枚举，均符合时返回true，枚举到卡牌数N结束。
      - 注意：这里为了内循环控制外循环，给外循环做了标记，即for()前面的search表示外循环。
*/
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        //定义卡牌数N，并遍历数组deck统计每个数字出现的次数
        int N = deck.length;
        int [] count = new int[10000];
        for(int i : deck){
            count[i]++;
        }

        int[] values = new int[10000];
        int index = 0;
        for(int j : count){
            if(j > 0){
                values[index++] = j;
            }
        }

        //从2开始，枚举可能的X，直到卡牌数N为止
        outer : for(int i = 2; i <= N; i++){
            //当i可以整除N时，继续判断i是否可以整除values数组中的每个值
            //一旦不符合，直接跳出，并继续执行外循环
            if(N % i == 0){
                for(int j : values){
                    if(j % i != 0)
                        continue outer;
                }
                //遍历数组values全部符合，则返回true
                return true;
            }
        }

        //枚举所有X后仍没有返回，则返回false
        return false;
    }
}
