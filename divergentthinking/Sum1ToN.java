package divergentthinking;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @ClassName: Sum1ToN
 * @description: 求1+2+3+...+n
 * @author: yyh
 * @create: 2020-03-28 09:39
 **/
public class Sum1ToN {

    /**
     * 当n=0时，sum=0，&&后面的就不会执行了，直接返回sum=0
     * @param n
     * @return
     */
    private static int Sum_Solution(int n) {
        int sum = n;
        //n=1时直接返回1
        boolean flag = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(10));
    }
}
