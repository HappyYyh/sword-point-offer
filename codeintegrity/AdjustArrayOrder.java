package codeintegrity;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @ClassName: AdjustArrayOrder
 * @description: 调整数组顺序使奇数位于偶数前面
 * @author: yyh
 * @create: 2020-02-21 10:28
 **/
public class AdjustArrayOrder {

    /**
     * my result(once pass) : 利用额外两个数组分别存储奇偶数，然后进行数组复制
     * 缺点是利用了额外空间
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param array
     */
    private static void reOrderArray(int [] array) {
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int val : array){
            if(val % 2 == 0){
                even[evenIndex ++] = val;
            }else {
                odd[oddIndex ++] =val;
            }
        }
        System.arraycopy(odd, 0, array, 0, oddIndex);
        System.arraycopy(even, 0, array, oddIndex, evenIndex);
    }


    /**
     * other : 插入排序
     * @param array
     */
    private static void reOrderArray2(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;
        for (int i = 1; i < n; i++) {
            // 当前元素是奇数，就移动到奇数序列
            if (array[i] % 2 != 0) {
                int value = array[i];
                int cur = i;
                while (cur > 0 && (array[cur - 1] % 2 == 0)) {
                    array[cur] = array[cur - 1];
                    cur--;
                }
                array[cur] = value;
            }
            // 当前元素是偶数，无须移动
        }
    }

    public static void main(String[] args) {
        int[] array = {2,1,4,3,7,6,9};
        reOrderArray2(array);
        System.out.println(Arrays.toString(array));
    }
}
