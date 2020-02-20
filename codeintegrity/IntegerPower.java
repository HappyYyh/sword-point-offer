package codeintegrity;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * @ClassName: IntegerPower
 * @description: 数值的整数次方
 * @author: yyh
 * @create: 2020-02-20 09:37
 **/
public class IntegerPower {

    private static double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }

    /**
     * my result : 连乘
     * 时间复杂度：O(n)
     * @param base
     * @param exponent
     * @return
     */
    private static double Power2(double base, int exponent) {
        if(base == 0){
            return base;
        }
        if(exponent == 0){
            return 1.0;
        }
        double res = 1.0;
        boolean flag = exponent > 0;
        for (int i = 0; i < Math.abs(exponent) ; i++) {
            res*= base;
        }
        return flag ? res : 1/res;
    }

    public static void main(String[] args) {
        System.out.println(Power2(2,3));
    }
}
