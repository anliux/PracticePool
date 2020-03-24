//17-打印从1到最大的n位数
//思路：不考虑大数问题；考虑大数问题



//不考虑大数问题：2ms，击败44%的用户
/*
    - 直接遍历：n为1时，10的1次方为10，10-1是9，从1遍历到9.
    - 定义10的n次方得到最大值；
    - 定义数组来存储这些值；
    - 从1开始遍历并将这些数存入结果数组；
    - 返回结果数组。
*/
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
