package efficiencybalance;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 *
 * All rights Reserved, Designed By yyh
 * 丑数
 * @Package efficiencybalance
 * @author: yyh
 * @date: 2020-03-12 10:50
 * @since V1.0.0-SNAPSHOT
 */
public class UglyNumber {

    /**
     * 1 2 3 4(2*2) 5 6(2*3) 8(2^3) 9(3*3) 10(2*5)
     * 丑数= (2^x)*(3^y)*(5^z)
     * other:
     * 而在2x，3y，5z中，如果x=y=z那么最小丑数一定是乘以2的，但关键是有可能存在x》y》z的情况，
     * 所以我们要维持三个指针来记录当前乘以2、乘以3、乘以5的最小值，
     * 然后当其被选为新的最小值后，要把相应的指针+1；
     * 因为这个指针会逐渐遍历整个数组，因此最终数组中的每一个值都会被乘以2、乘以3、乘以5，
     * 也就是实现了我们最开始的想法，只不过不是同时成乘以2、3、5，而是在需要的时候乘以2、3、5.
     *
     * @param index
     * @return
     */
    private static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        //初始化三个指向三个潜在成为最小丑数的位置
        int p2 = 0, p3 = 0, p5 = 0;
        int[] result = new int[index];
        result[0] = 1;
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            //为了防止重复需要三个if都能够走到
            if (result[i] == result[p2] * 2) {
                p2++;
            }
            if (result[i] == result[p3] * 3) {
                p3++;
            }
            if (result[i] == result[p5] * 5) {
                p5++;
            }
        }
        return result[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }
}
