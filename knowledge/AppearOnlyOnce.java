package knowledge;

import java.util.ArrayList;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 注意：
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 * <p>
 * All rights Reserved, Designed By yyh
 * 数组中只出现一次的数字
 *
 * @Package knowledge
 * @author: yyh
 * @date: 2020-03-19 10:50
 * @since V1.0.0-SNAPSHOT
 */
public class AppearOnlyOnce {

    /**
     * my result : list空间存储，
     *
     * @param array
     * @param num1
     * @param num2
     */
    private static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 1) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : array) {
            if (list.contains(val)) {
                list.remove(Integer.valueOf(val));
            } else {
                list.add(val);
            }
        }
        if (list.size() == 2) {
            num1[0] = list.get(0);
            num2[0] = list.get(1);
        }
    }

    /**
     * other:异或法（相同的数异或为0，一个数和0异或为本身）
     * 首先把所有数字异或，得到的结果就是这两个数异或的值。
     * 这个结果的二进制中的1，表现的是A和B的不同的位。
     * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
     * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
     * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     *
     * @param array
     * @param num1
     * @param num2
     */
    private static void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        int xor1 = 0;
        for (int value : array) {
            xor1 = xor1 ^ value;
        }
        //在xor1中找到第一个不同的位对数据进行分类，分类为两个队列对数据进行异或求和找到我们想要的结果
        int index = 1;
        while ((index & xor1) == 0) {
            //因为可能有多个位为1所以需要求一下位置
            index = index << 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int value : array) {
            if ((index & value) == 0) {
                result1 = result1 ^ value;
            } else {
                result2 = result2 ^ value;
            }
        }
        num1[0] = result1;
        num2[0] = result2;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 1, 4, 3};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce2(array, num1, num2);
        System.out.println("num1 : " + num1[0] + " ,num2 : " + num2[0]);
    }
}
