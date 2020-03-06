package decompose;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 注意：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * All rights Reserved, Designed By yyh
 * 字符串的排列
 * @Package decompose
 * @author: yyh
 * @date: 2020-03-06 9:15
 * @since V1.0.0-SNAPSHOT
 */
public class PermutationOfStr {

    //https://blog.nowcoder.net/n/dfd91d416f064002b8b05e89953d5b92?f=comment

    /**
     * 字典序法
     * 1、从右向左找到第一个正序对（array[i] < array[i+1]，因为没有等号，所以可以完美去掉重复的排列）
     * 2、从i开始向右搜索，找到比array[i]大的字符中最小的那个，记为array[j]
     * 3、交换array[i]和array[j]
     * 4、将i后面的字符反转
     * 这就得到了字典序的下一个排列。
     * 连续使用这个方法则可从字典序最小的排列推出全部排列。
     * 时间复杂度O(n*n!)
     * @param str
     * @return
     */
    private static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0){
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        res.add(str);
        while(true){
            s = nextString(s);
            if(!"finish".equals(s)){
                res.add(s);
            } else{
                break;
            }
        }
        return res;
    }

    private static String nextString(String str){
        char[] array = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        for (; i >= 0 && array[i] >= array[i + 1]; i--) ;
        if (i == -1) {
            return "finish";
        }
        int j = length - 1;
        for (; j >= 0 && array[j] <= array[i]; j--) ;
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for (int a = i + 1, b = length - 1; a < b; a++, b--) {
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> list = Permutation(str);
        list.forEach(System.out::println);
    }
}
