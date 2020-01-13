package str;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * All rights Reserved, Designed By yyh
 * 替换空格
 * @Package str
 * @author: yyh
 * @date: 2020-01-13 16:26
 * @since V1.0.0-SNAPSHOT
 */
public class ReplaceSpace {

    /**
     * my result(once pass) ；利用string的api
     * @param str
     * @return
     */
    private static String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }

    /**
     * my result :遍历
     * @param str
     * @return
     */
    private static String replaceSpace2(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toString().toCharArray()){
            if(c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("We Are Happy");
        System.out.println(replaceSpace2(sb));
    }
}
