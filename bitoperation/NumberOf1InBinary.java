package bitoperation;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @ClassName: NumberOf1InBinary
 * @description: 二进制中1的个数
 * @author: yyh
 * @create: 2020-02-19 09:52
 **/
public class NumberOf1InBinary {


    private static String convert4(int n){
        return Integer.toBinaryString(n);
    }

    /**
     * my result : 调用函数
     * @param n
     * @return
     */
    private static int NumberOf1(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i <binaryString.length() ; i++) {
            if(binaryString.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }


    /**
     * other：整数n，进行n&(n-1)运算，会把二进制表示中最右边的1变为0。
     * 举例 n = 15
     * num      n             n-1           res
     * 1       1111 (15)     1110 (14)    1110 (14)
     * 2       1110 (14)     1101 (13)    1100 (12)
     * 3       1100 (12)     1011 (11)    1000 (8)
     * 4       1000 (8)      0111 (7)     0000 (0)
     * 结束，由上可以看出15(1111) 在操作的时候逐位消除1的个数
     * @param n
     * @return
     */
    private static int NumberOf12(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n &= (n - 1);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(convert4(-234));
        System.out.println(NumberOf1(15));
        System.out.println(NumberOf12(15));
    }
}
