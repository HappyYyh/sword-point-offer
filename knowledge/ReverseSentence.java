package knowledge;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * All rights Reserved, Designed By yyh
 * 翻转单词顺序列
 * @Package knowledge
 * @author: yyh
 * @date: 2020-03-25 10:28
 * @since V1.0.0-SNAPSHOT
 */
public class ReverseSentence {

    /**
     * my result : str.split分割空格然后重新拼接
     * @param str
     * @return
     */
    private static String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] splits = str.split(" ");
        if(splits.length == 0){
            return str;
        }
        for (int i = splits.length - 1; i >= 0 ; i--) {
            sb.append(splits[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }


    /**
     * other : 不借助任何api
     * @param str
     * @return
     */
    private static String ReverseSentence2(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverseChars(chars, 0, str.length() - 1);
        // 利用滑动窗口
        // 遇到' '执行翻转
        int l = 0;
        int r = 0;
        while (l < str.length()) {
            if (chars[r] == ' ') {
                reverseChars(chars, l, r - 1);
                // 交换完之后,一起跳过' '
                r++;
                l = r;
            }
            if (r == str.length() - 1) {
                reverseChars(chars, l, r);
                // 到了最后交换玩就break，否则r会出现越界，可以在while中加对r的判断
                break;
            }
            r++;
        }
        return String.valueOf(chars);
    }
    private static void reverseChars(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence2("student. a am I"));
    }
}
