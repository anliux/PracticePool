//10.1 - 斐波那契数列
//递归；循环(自下而上)；公式；查表

//递归：超时
class Solution {
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fib(n-1) + fib(n-2);
    }
}

//循环：0ms，击败100%
class Solution {
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int a = 0, b = 1, sum=0;
        for(int i=2; i<=n; i++){
            sum = (a+b) % 1000000007;//注意：需要在求和这里就取模
            a = b;
            b = sum;
        }
        return sum;
    }
}

//公式法：略

//查表法：摘自评论区
int f[]={0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986,102334155,165580141,267914296,433494437,701408733,134903163,836311896,971215059,807526948,778742000,586268941,365010934,951279875,316290802,267570670,583861472,851432142,435293607,286725742,722019349,8745084,730764433,739509517,470273943,209783453,680057396,889840849,569898238,459739080,29637311,489376391,519013702,8390086,527403788,535793874,63197655,598991529,662189184,261180706,923369890,184550589,107920472,292471061,400391533,692862594,93254120,786116714,879370834,665487541,544858368,210345902,755204270,965550172,720754435,686304600,407059028,93363621,500422649,593786270,94208912,687995182};
int fib(int n){
    return f[n];
}
