package knowledge;

import java.util.LinkedList;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 *
 * @ClassName: LeftRotateString
 * @description: 左旋转字符串
 * @author: yyh
 * @create: 2020-03-24 15:23
 **/
public class LeftRotateString {

    /**
     * my result (once pass): 利用linkedList先进先出的特性
     * @param str
     * @param n
     * @return
     */
    private static String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n < 0){
            return "";
        }
        n = n % str.length();
        LinkedList<Character> list = new LinkedList<>();
        for(char c : str.toCharArray()){
            list.push(c);
        }
        for (int i = 0; i < n ; i++) {
            list.push(list.pollLast());
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()){
            sb.append(list.pollLast());
        }
        return sb.toString();
    }

    /**
     * other : 利用subString
     * @param str
     * @param n
     * @return
     */
    private static String LeftRotateString2(String str, int n) {
        if (str == null || n > str.length()) {
            return str;
        }
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString2("abcXYZdef",3));
    }
}
