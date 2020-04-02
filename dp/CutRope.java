package dp;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 * 。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 *
 * All rights Reserved, Designed By yyh
 * 剪绳子
 * @Package dp
 * @author: yyh
 * @date: 2020-04-02 10:07
 * @since V1.0.0-SNAPSHOT
 */
public class CutRope {

    /**
     * my result : 一个数开根后连乘值最大
     * @param target
     * @return
     */
    private static int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        // 四舍五入取开根值
        int len = (int)Math.round(Math.sqrt(target));
        int sum = 1;
        while (target >= 2 * len){
            target -= len;
            sum *= len;
        }
        // 剩余的target < 2 * len,最大值就是*target
        return sum * target;
    }


    /**
     * 解题思路，找出最优解的规律
     * 当target等于1，2，3的时候，结果是固定的
     * 当target大于3的时候，可以看以下数据
     * target=4, 最优解：2 2
     * target=5, 最优解：3 2
     * target=6, 最优解：3 3
     * target=7, 最优解：3 2 2
     * target=8, 最优解：3 3 2
     * target=9, 最优解：3 3 3
     * target=10,最优解：3 3 2 2
     * target=11,最优解：3 3 3 2
     * target=12,最优解：3 3 3 3
     * target=13,最优解：3 3 3 2 2
     * target=14,最优解：3 3 3 3 2
     * target=15,最优解：3 3 3 3 3
     *
     * 所以不难发现3和2的个数规律
     */
    private static int cutRope2(int target) {
        if (target <= 1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        //数字长度
        int length = target % 3 == 0 ? target / 3 : target / 3 + 1;
        //数字后面2的个数
        int length2 = 3 - target % 3;
        int result = 1;
        //算乘积
        for (int i = 0; i < length; i++) {
            result = result * (i < length - length2 ? 3 : 2);
        }
        return result;
    }

    private static int cutRope3(int n) {
        // n<=3的情况，m>1必须要分段，例如：3必须分成1、2；1、1、1 ，n=3最大分段乘积是2,
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        /*
         *下面3行是n>=4的情况，跟n<=3不同，4可以分很多段，比如分成1、3，
         *这里的3可以不需要再分了，因为3分段最大才2，不分就是3。记录最大的。
         */
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //记录最大的
        int res = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(10));
        System.out.println(cutRope2(10));
        System.out.println(cutRope3(10));
        System.out.println();
    }
}
