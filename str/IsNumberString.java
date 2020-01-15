package str;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * All rights Reserved, Designed By yyh
 * 表示数值的字符串
 * @Package str
 * @author: yyh
 * @date: 2020-01-15 14:22
 * @since V1.0.0-SNAPSHOT
 */
public class IsNumberString {

    /**
     * my result : 一遍一遍过测试用例
     * 时间复杂度：O(n)
     * @param str
     * @return
     */
    private static boolean isNumeric(char[] str) {
        int len = str.length;
        if(len == 0){
            return false;
        }else if(len == 1){
            return Character.isDigit(str[0]);
        }else {
            return check(str);
        }
    }

    private static boolean check(char[] str){
        int eNum = 0;
        int pointNum = 0;
        int plusNum = 0;
        int mixNum = 0;
        for (int i = 0; i < str.length ; i++) {
            if(str[i] == '.'){
                // .的数量不能超过1并且前名不会出现e
                if(++pointNum > 1 ||  eNum != 0){
                    return false;
                }
                if(i != 1){
                    // 除了第二位可以为点外其余情况出现的点 必须满足前后都是数字 并且不是最后一位
                    if((!Character.isDigit(str[i-1]) && !Character.isDigit(str[i + 1])) || i == str.length -1){
                        return false;
                    }
                }
            }else if(str[i] == 'e' || str[i] == 'E'){
                if(++eNum > 1){
                    return false;
                }
                // e的后面必须是数字 并且不是最后一位
                if(!Character.isDigit(str[i-1]) || i == str.length -1){
                    return false;
                }
            } else if(str[i] == '-'){
                // -数量不超过2
                if(++ mixNum > 2){
                    return false;
                }
                if(i != 0){
                    // 除了在首位 ，其余出现-号 则前一位必须是e 后一位必须是数字
                    if((str[i-1] != 'E' && str[i-1] !='e') ||  i == str.length-1 || !Character.isDigit(str[i+1])){
                        return false;
                    }
                }
            }else if(str[i] == '+'){
                // +数量不超过2
                if(++plusNum > 2){
                    return false;
                }
                if(i != 0) {
                    // 除了在首位 ，其余出现+号 则前一位必须是e 后一位必须是数字
                    if ((str[i - 1] != 'E' && str[i - 1] != 'e') || i == str.length - 1 || !Character.isDigit(str[i + 1])) {
                        return false;
                    }
                }
            }else if(!Character.isDigit(str[i])){
                // 排除其他字符
                return false;
            }
        }
        return true;
    }

    /**
     * other : 正则匹配
     *
     * 以下对正则进行解释:
     * [\\+\\-]?            -> 正或负符号出现与否
     * \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
     *                         否则一起不出现
     * ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
     *                         紧接着必须跟着整数；或者整个部分都不出现
     *
     * @param str
     * @return
     */
    private static boolean isNumeric2(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    public static void main(String[] args) {
        char[] str = {'+','1','0','0'};
        char[] str1 = {'5','e','2'};
        char[] str2 = {'-','1','2','3'};
        char[] str3 = {'+','3','.','1','4','1','6'};
        char[] str4 = {'+','3','.','1','4','1','6'};
        System.out.println(isNumeric(str));
        System.out.println(isNumeric(str1));
        System.out.println(isNumeric(str2));
        System.out.println(isNumeric(str3));
        System.out.println(isNumeric(str4));
        char[] str5 = {'1','2','e'};
        char[] str6 = {'1','a','3','.','1','4'};
        char[] str7 = {'1','.','2','.','3'};
        char[] str8 = {'+','-','5'};
        char[] str9 = {'1','2','e','+','4','.','3'};
        System.out.println(isNumeric(str5));
        System.out.println(isNumeric(str6));
        System.out.println(isNumeric(str7));
        System.out.println(isNumeric(str8));
        System.out.println(isNumeric(str9));
        System.out.println(isNumeric(new char[]{'-','.','1','2','3'}));
    }
}
