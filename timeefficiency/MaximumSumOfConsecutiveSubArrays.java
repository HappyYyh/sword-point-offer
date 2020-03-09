package timeefficiency;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 *
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * All rights Reserved, Designed By yyh
 * 连续子数组的最大和
 * @Package timeefficiency
 * @author: yyh
 * @date: 2020-03-09 9:43
 * @since V1.0.0-SNAPSHOT
 */
public class MaximumSumOfConsecutiveSubArrays {

    /**
     * my result : 暴力破解，进行枚举
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * @param array
     * @return
     */
    private static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1){
            return array[0];
        }
        int max = array[0];
        for (int i = 0; i < array.length ; i++) {
            int sum = array[i];
            // 判断第一个是否比max大
            if(sum > max){
                max = sum;
            }
            for (int j = i + 1; j < array.length ; j++) {
                // 累加连续值
                sum += array[j];
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * leetcode53:动态规划
     * 如果全是负数则 sum不断更新，max = 最大的负数
     * 如果全是正数则 sum 一值累加，max = 连续求和
     * 其余情况，
     * @param array
     * @return
     */
    private static int FindGreatestSumOfSubArray2(int[] array) {
        int max = array[0];
        int sum = 0;
        for(int num: array) {
            if(sum > 0) {
                sum += num;
            } else {
                // 只要累加是负数，则从最新的开始计算
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * other:动态规划
     * dp[n]代表以当前元素为截止点的连续子序列的最大和，
     * 如果dp[n-1]>0，dp[n]=dp[n]+dp[n-1]，因为当前数字加上一个正数一定会变大；
     * 如果dp[n-1]<0，dp[n]不变，因为当前数字加上一个负数一定会变小。
     * 使用一个变量max记录最大的dp值返回即可。
     *
     * @param array
     * @return
     */
    private static int FindGreatestSumOfSubArray3(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray3(array));
    }
}
