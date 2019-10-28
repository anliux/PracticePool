//16 - 数值的整数次方
//实现pow函数
//可直接调用；可使用次方的奇数偶数分解等式迭代求解

//直接调用pow函数
public class Solution {
    public double Power(double base, int exponent) {
        return Math.pow(base,exponent);
  }
}

//使用次方的分解等式迭代
public class Solution {
    public double Power(double base, int exponent) {
        //判断指数的特殊情况：为0返回1，为1返回base
		if(exponent==0)
            return 1;
        if(exponent==1)
            return base;

		//考虑指数为负时，设置一个标志，并在计算时取相反数，结果处取倒数
        boolean isNegative = false;
        if(exponent<0){
            isNegative = true;
            exponent = -exponent;
        }

		//根据指数的分解公式进行迭代
        double pow = Power(base*base, exponent/2);
        //判断指数的奇偶性，奇数时需求额外乘以一次底数
		if(exponent%2 != 0){
            pow = pow * base;
        }

		//返回时进行判断指数是否为负数，如果为负，取倒数；否则，直接返回。
        return isNegative?(1/pow):pow;
  }
}