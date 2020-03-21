package sort;

import java.util.Arrays;

/**
 * @ClassName: SelectSort
 * @description: 选择排序
 * @author: yyh
 * @create: 2020-03-21 11:51
 **/
public class SelectSort {

    /**
     * 选择排序：在未排序序列中找到最小元素，存放到排序序列的起始位置。
     * @param array
     */
    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            //选出之后待排序中值最小的位置
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            //最小值不等于当前值时进行交换
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 5, 2, 1};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        selectSort(array);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
