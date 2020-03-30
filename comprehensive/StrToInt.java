package comprehensive;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 示例:
 * +2147483647 -> 2147483647
 * 1a33 -> 0
 *
 * All rights Reserved, Designed By yyh
 * 把字符串转换成整数
 * @Package comprehensive
 * @author: yyh
 * @date: 2020-03-30 10:03
 * @since V1.0.0-SNAPSHOT
 */
public class StrToInt {

    /**
     * my result : 逐位相乘
     * @param str
     * @return
     */
    private static int StrToInt(String str) {
        char[] chars = str.toCharArray();
        if (chars.length < 1 || chars.length > 11) {
            return 0;
        }
        long val = 0;
        for (int i = chars.length - 1; i >= 1; i--) {
            if (Character.isDigit(chars[i])) {
                val += (chars[i] - '0') * Math.pow(10, chars.length - 1 - i);
            } else {
                return 0;
            }
        }
        // 判断首位
        if (chars[0] == '+' || chars[0] == '-') {
            val *= chars[0] == '+' ? 1 : -1;
        } else if (Character.isDigit(chars[0])) {
            val += (chars[0] - '0') * (int) Math.pow(10, chars.length - 1);
        } else {
            return 0;
        }
        // 溢出判断
        return val > Integer.MAX_VALUE ? 0 : val < Integer.MIN_VALUE ? 0 : (int) val;
    }

    /**
     * other:捕获异常
     * @param str
     * @return
     */
    private static int StrToInt2(String str) {
        int res;
        try {
            res = new Integer(str);
        } catch (NumberFormatException e) {
            res = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt2("a47483648"));
    }
}
