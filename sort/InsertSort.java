package sort;

import java.util.Arrays;

/**
 * @ClassName: InsertSort
 * @description: 插入排序
 * @author: yyh
 * @create: 2020-03-21 12:05
 **/
public class InsertSort {

    /**
     * 插入排序：对于欲排序的元素以插入的方式找寻该元素的适当位置
     * @param array
     */
    private static void insertSort(int[] array) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;
            // 给 insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertVal;
            }
        }
    }

    /**
     * 插入排序
     * @param array
     */
    private static void insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 待插入的值
            int num = array[i];
            int j;
            for (j = i; j > 0 && num < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = num;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 5, 2, 1};
        System.out.println("排序前顺序：" + Arrays.toString(array));
        insertSort2(array);
        System.out.println("排序后顺序：" + Arrays.toString(array));
    }
}
