package efficiencybalance;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * All rights Reserved, Designed By yyh
 * 第一个只出现一次的字符
 * @Package efficiencybalance
 * @author: yyh
 * @date: 2020-03-13 10:20
 * @since V1.0.0-SNAPSHOT
 */
public class FirstAppearOnceChar {

    /**
     * my result (once pass):利用数组(哈希表)记录每个字符出现的次数，然后找出第一个出现一次的字符
     * 时间复杂度：O(n)
     * 空间复杂度：O(58)
     * @param str
     * @return
     */
    private static int FirstNotRepeatingChar(String str) {
        //根据题意，str由大小写字母组成，根据ASCII表，A-z 分别是65-122，所以可以用58大小的数组存储
        int[] tmp = new int[58];
        for (char c : str.toCharArray()) {
            tmp[c - 65]++;
        }
        for (int i = 0; i < str.length() ; i++) {
            if(tmp[str.charAt(i)-65] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("aABABbdCD"));
    }
}
