//0914-卡牌分组
//思路：暴力法；最大公约数法。



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



//最大公约数法：4ms，击败66.82%的用户
/*
 - 算法：
      - 定义求最大公约数gcd的函数：将除数和余数作为新参数传入，并递归，直到余数为0，这时返回除数。
      - 首先定义计数数组，遍历原数组并求出每个数字出现的次数，并存入计数数组中；
      - 定义公约数变量g：
        - 注意：初始化为-1，并且在计数数组元素大于0时赋值，是为了绕过0，避免所有公约数都被计算为0，又保证了获取的是计数数组中的元素。
      - 遍历计数数组，并计算大于0的元素与公约数g的最大公约数；
      - 最后，判断g是否大于等于2，符合则返回true，否则返回false。
*/
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        //定义计数数组count，遍历deck数组并统计每个数字出现次数存入count数组
        int [] count = new int[10000];
        for(int i : deck)
            count[i]++;
        
        //定义公约数变量g，并初始化为非0的负数。（为了绕开0）
        int g = -1;

        //遍历计数数组，并选取其中大于0的元素与g计算最大公约数。
        for(int j : count){
            if(j > 0){
                if(g == -1)
                    g = j;
                else
                    g = gcd(g, j);
            }
        }

        //判断最大公约数是否大于等于2：题目要求的
        return g>=2;
    }

    private int gcd(int a, int b){
        //将被除数和除数传入，然后将计算得到的除数和余数作为新的参数传入，直到余数为0
        return (b == 0) ? a : gcd(b, (a%b));
    }
}
