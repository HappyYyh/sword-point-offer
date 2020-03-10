package timeefficiency;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * All rights Reserved, Designed By yyh
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * @Package timeefficiency
 * @author: yyh
 * @date: 2020-03-10 9:58
 * @since V1.0.0-SNAPSHOT
 */
public class OccurrencesOf1InTheInteger {

    /**
     * my result (once pass) : 暴力破解
     * 太耗时，不推荐
     * 时间复杂度：O(n * lgN)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    private static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            String str = String.valueOf(i);
            if(str.contains("1")){
                char[] chars = str.toCharArray();
                for (char c : chars){
                    if(c == '1'){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * other:除10计数
     * 时间复杂度：O(n * lgN)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    private static int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        for (int i = 1; i <= n ; i ++ ) {
            for (int j = i; j > 0; j /= 10) {
                if (j % 10 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * other:分别计算个位、十位、百位........上出现 1 的个数。
     * 以  n =216为例：
     * 个位上： 1 ，11，21，31，.....211。个位上共出现（216/10）+ 1个 1 。因为除法取整，210~216间个位上的1取不到，所以我们加8进位。你可能说为什么不加9，n=211怎么办，这里把最后取到的个位数为1的单独考虑，先往下看。
     * 十位上：10~19，110~119，210~216. 十位上可看成 求（216/10）=21 个位上的1的个数然后乘10。这里再次把最后取到的十位数为1的单独拿出来，即210~216要单独考虑 ，个数为（216%10）+1 .这里加8就避免了判断的过程。
     * 后面以此类推。
     * 时间复杂度 O(logN)
     * @param n
     * @return
     */
    private static int NumberOf1Between1AndN_Solution3(int n) {
        int count = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            count += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }


    /**
     * other:https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6?f=discussion
     * @param n
     * @return
     */
    private static int NumberOf1Between1AndN_Solution4(int n) {
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver  = i * 10;
            count += (n / diviver ) * i + Math.min(Math.max(n % diviver  - i + 1, 0), i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution4(2000000000));
    }
}
