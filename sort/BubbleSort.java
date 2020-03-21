package sort;

import java.util.Arrays;

/**
 * @ClassName: BubbleSort
 * @description: 冒泡排序
 * @author: yyh
 * @create: 2020-03-21 11:22
 **/
public class BubbleSort {

    /**
     * 冒泡排序(从小到大)：比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * @param array
     */
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 5, 2, 1};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
