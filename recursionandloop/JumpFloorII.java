package recursionandloop;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @ClassName: JumpFloorII
 * @description: 变态跳台阶
 * @author: yyh
 * @create: 2020-02-17 09:32
 **/
public class JumpFloorII {

    /**
     * my result (once pass):根据规律可以得出 f(n) = 2 ^ (n-1)
     * 时间复杂度：O(1)
     * @param target
     * @return
     */
    private static int JumpFloorII(int target) {
        //return (int) Math.pow(2, target - 1);
        return 1 << (target - 1);
    }

    /**
     *  n         跳法
     *  1          1
     *  2          1 1 / 2
     *  3          1 1 1 / 1 2 / 2 1 / 3
     *  4          1 1 1 1 / 1 2 1 / 2 1 1 / 1 1 2/ 2 2  / 1 3 / 3 1 / 4
     *  f(n) = f(n-1) + f(n-2) + ... + f(2) + f(1) + 1(这个是本身)
     *
     *  已知：
     *  f(n)=f(n-1)+f(n-2)+……f(1)
     *  f(n-1)=f(n-2)+……f(1)
     *  相减得：
     *  f(n) = 2 * f(n-1)
     *  而：
     *  f(1) = 1
     *  故：
     *  f(n) = pow(2, n - 1)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(JumpFloorII(1));
    }
}
