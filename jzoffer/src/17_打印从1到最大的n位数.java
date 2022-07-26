//17-打印从1到最大的n位数
//思路：不考虑大数问题；考虑大数问题



//不考虑大数问题：0ms，击败100%的用户
class Solution {
    public int[] printNumbers(int n) {
        //定义最大值，并定义数组
        int max = (int) Math.pow(10,n);
        int [] arr = new int[max - 1];

        //遍历，并将数组添加到数组中
        for(int i = 0; i < max-1; i++){
            arr[i] = i + 1;
        }

        //返回结果数组
        return arr;
    }
}



//大数问题注释版：多个全局变量 & 考虑转为int数组返回结果
class Solution {
    int[] res;
    //start表示该数字当前左边界，这个左边界意思是指当前数字最高位对应的char数组下标。如n=2时，1~9左边界为1，10~99左边界为0
    //nine表示当前数字中出现了多少个9，如果出现1个9，左边界就要向左移1位。例如第1次出现“9”是在9这个数字出现的时候，此时nine++变为1，
    //进入下次递归n为2，nine为1，start为1，此时start就要-1，以便统计二位数字
    int nine = 0, count = 0, start, n;   
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        //用来保存最终数字结果的
        res = new int[(int)Math.pow(10, n) - 1];   
        //num数组用来表示字符串，比如n等于2，则num数组为['0''0']、['0''1']、['0''2']...后边是将它转为字符串并按照左边界的位置进行截取的
        num = new char[n];  
        start = n - 1;  //最开始的左边界是从n-1，开始的，因为char数组的下标是从0开始，最末一位为n-1
        dfs(0);   //从char数组的第0位开始
        return res;
    }
    void dfs(int x) {
        //结束条件：当前x的下标越过char数组的最后一位下标n-1，此时记录结果
        if(x == n) {
            String s = String.valueOf(num).substring(start);   //从start开始截取字符串，如"01"截取后就是"1"
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);   //防止将"0"、"00"、"000"加进来
            if(n - start == nine) start--;   //n减去start等于nine，表示要进位了，进位就是将左边界start左移一位，即-1
            return;
        }
        //给char数组第x位添加数字，添加完后进入下一位
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;   //回溯
    }
}




//考虑大数问题：
public void print1ToMaxOfNDigits(int n) {
    if (n <= 0)
        return;
    char[] number = new char[n];
    print1ToMaxOfNDigits(number, 0);
}

private void print1ToMaxOfNDigits(char[] number, int digit) {
    if (digit == number.length) {
        printNumber(number);
        return;
    }
    for (int i = 0; i < 10; i++) {
        number[digit] = (char) (i + '0');
        print1ToMaxOfNDigits(number, digit + 1);
    }
}

private void printNumber(char[] number) {
    int index = 0;
    while (index < number.length && number[index] == '0')
        index++;
    while (index < number.length)
        System.out.print(number[index++]);
    System.out.println();
}
