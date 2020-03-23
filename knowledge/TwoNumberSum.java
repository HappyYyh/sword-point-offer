package knowledge;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的
 * <p>
 * 注：
 * 对应每个测试案例，输出两个数，小的先输出。
 * <p>
 * All rights Reserved, Designed By yyh
 * 和为S的两个数字
 *
 * @Package knowledge
 * @author: yyh
 * @date: 2020-03-23 9:52
 * @since V1.0.0-SNAPSHOT
 */
public class TwoNumberSum {

    /**
     * my result : 暴力枚举，找出最小成绩
     * 时间复杂度 : O(n^2)
     *
     * @param array
     * @param sum
     * @return
     */
    private static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int minMultiply = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    if (array[i] * array[j] < minMultiply) {
                        minMultiply = array[i] * array[j];
                        list.clear();
                        list.add(array[i]);
                        list.add(array[j]);
                    }
                }
            }
        }
        return list;
    }

    /**
     * my result(once pass) : 双指针法
     * 时间复杂度 : O(n)
     *
     * @param array
     * @param sum
     * @return
     */
    private static ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        int minMultiply = Integer.MAX_VALUE;
        while (left < right) {
            int add = array[left] + array[right];
            if (add < sum) {
                left++;
            } else if (add > sum) {
                right--;
            } else {
                int multiply = array[left] * array[right];
                if (multiply < minMultiply) {
                    minMultiply = multiply;
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                }
                left++;
                right--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {1, 10, 11, 20};
        ArrayList<Integer> list = FindNumbersWithSum2(array, 21);
        for (Integer val : list) {
            System.out.println(val);
        }
    }
}
