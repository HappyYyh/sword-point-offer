package recursionandloop;

/**
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @ClassName: Fibonacci
 * @description: 斐波那契数列
 * @author: yyh
 * @create: 2020-02-14 11:03
 **/
public class Fibonacci {

    /**
     * 递归写法
     * 时间复杂度：O(2^n)
     * @param n
     * @return
     */
    private static int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 循环过程：
     * 以n=6为例(这里的n指n--后的循环)
     * n    next    curr
     * 6    1       0
     * 5    1       1
     * 4    2       1
     * 3    3       2
     * 2    5       3
     * 1    8       5
     * 0    13      8
     * 由上可以看出curr即当前的fib，next为下一个fib
     * @param n
     * @return
     */
    private static int Fibonacci2(int n) {
        int curr = 0, next = 1;
        while(n-- > 0) {
            next = next + curr;
            curr = next - curr;
        }
        return curr;
    }

    /**
     * other:递归的优化，用数组把前一个结果存起来
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     * @param n
     * @return
     */
    private static int Fibonacci3(int n) {
        int[] ans = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci2(6));
    }
}
