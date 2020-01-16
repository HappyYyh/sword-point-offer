package str;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * All rights Reserved, Designed By yyh
 * 字符流中第一个不重复的字符
 * @Package str
 * @author: yyh
 * @date: 2020-01-16 16:33
 * @since V1.0.0-SNAPSHOT
 */
public class FirstUniqueCharacter {

    /**
     * 通过insert方法不断传入，保存到一个对象中，这里就是用StringBuilder保存
     * 由于一个字符占8位，所以可以用hash表来存储字符，index为字符，value为出现的个数
     * 但是对于中文的支持就不行了，因为中文char占2-3个字节，所以可以用TreeMap进行实现
     */
    private static int[] hashtable = new int[256];
    private static StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    private static void Insert(char ch) {
        sb.append(ch);
        hashtable[ch]++;
    }
    //return the first appearence once char in current stringstream
    private static char FirstAppearingOnce() {
        char[] str= sb.toString().toCharArray();
        for(char c:str) {
            if(hashtable[c]==1) {
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Insert('喊');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
    }
}
